package developer.task;

import developer.task.XMLInteraction.XMLParser;
import developer.task.XMLInteraction.XMLWriter;
import developer.task.structureXML.output.Output;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleFileVisitorExt extends SimpleFileVisitor<Path> {

    private final Pattern pattern = Pattern.compile("^file\\d+\\.xml", Pattern.CASE_INSENSITIVE);

    @Override
    public FileVisitResult visitFile(Path pathFile, BasicFileAttributes attrs) throws IOException {
        if (!checkPath(pathFile)) {
            return FileVisitResult.CONTINUE;
        }

        File file = pathFile.toFile();
        if (file.canWrite()) {
            try (FileOutputStream stream = new FileOutputStream(file, true)) { // TODO: 11/5/19 try-with resources // хотел дописать и забыл, спасибо
                processData(file);
            }
        }

        return FileVisitResult.CONTINUE;
    }

    private Boolean checkPath(Path pathFile) {
        Matcher matcher = pattern.matcher(pathFile.getFileName().toString());

        if (!Files.isRegularFile(pathFile)) {
            return false;
        } else {
            return matcher.find();
        }
    }

    @SneakyThrows
    private void processData(File file) {
        String fileName = "/avg_" + file.getName();
        String absolutePath = file.getParentFile().getAbsolutePath().replace("\\", "/");
        String pathFile = absolutePath + fileName;

        Output output = XMLParser.parseXMLWithMapper(file);
        XMLWriter.writeXMLWithMapper(output, pathFile);

        String oldPath = absolutePath + "/" + file.getName();
        String newPath = absolutePath + "/read-files/" + file.getName();
//        Files.move(Paths.get(oldPath), Paths.get(newPath), StandardCopyOption.REPLACE_EXISTING); // тут сыпется WindowsException
    }
}
