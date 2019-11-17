package developer.task;

import developer.task.XMLInteraction.XMLParser;
import developer.task.XMLInteraction.XMLWriter;
import developer.task.structureXML.output.Output;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFilesMonitoring implements Runnable {

    private final String readFiles = "/read-files";
    private final Pattern patternReadFiles = Pattern.compile(readFiles + "(/|$)");
    private final Pattern patternFileName = Pattern.compile("^file\\d+\\.xml", Pattern.CASE_INSENSITIVE);

    private Path pathFile;

    public LogFilesMonitoring(Path pathFile) {
        this.pathFile = pathFile;
    }

    public LogFilesMonitoring(String pathFile) {
        this.pathFile = Paths.get(pathFile);
    }

    @SneakyThrows
    @Override
    public void run() {
        if (!checkPath(pathFile)) {
            return;
        }

        try (FileOutputStream stream = new FileOutputStream(pathFile.toFile(), true)) {
            processData();
        }

        moveFile();
    }

    private Boolean checkPath(Path pathFile) {
        String absolutePath = pathFile.toAbsolutePath().toString().replace("\\", "/");

        Matcher matcherReadFiles = patternReadFiles.matcher(absolutePath);
        Matcher matcherFileName = patternFileName.matcher(pathFile.getFileName().toString());

        if (!Files.isRegularFile(pathFile)) {
            return false;
        } else {
            return !matcherReadFiles.find() && matcherFileName.find();
        }
    }

    private void processData() {
        File file = pathFile.toFile();
        String fileName = "/avg_" + file.getName();
        String absolutePath = file.getParentFile().getAbsolutePath().replace("\\", "/");
        String pathFile = absolutePath + fileName;

        Output output = XMLParser.parseXMLWithMapper(file);
        XMLWriter.writeXMLWithMapper(output, pathFile);
    }

    @SneakyThrows
    private void moveFile() {
        String absolutePath = pathFile.getParent().toAbsolutePath().toString().replace("\\", "/");
        String fileName = pathFile.getFileName().toString();

        String pathReadFile = absolutePath + readFiles;
        checkFileAvailability(pathReadFile, true);

        String oldPath = absolutePath + "/" + fileName;
        String newPath = pathReadFile + "/" + fileName;

        checkFileAvailability(newPath, false);
        Files.move(Paths.get(oldPath), Paths.get(newPath), StandardCopyOption.REPLACE_EXISTING);
    }

    @SneakyThrows
    private Boolean checkFileAvailability(String filePath, Boolean isDirectory) {
        File file = new File(filePath);
        if (!file.exists()) {
            if (isDirectory) {
                return file.mkdir();
            } else {
                return file.createNewFile();
            }
        }

        return true;
    }
    @SneakyThrows
    public static void main(String[] args) {
        String pathFiles = "./developer-task-logs/file1.xml";

        Thread thread = new Thread(new LogFilesMonitoring(pathFiles));
        thread.start();
    }
}
