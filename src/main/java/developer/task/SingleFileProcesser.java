package developer.task;

import developer.task.XMLInteraction.XMLParser;
import developer.task.XMLInteraction.XMLWriter;
import developer.task.structureXML.output.Output;
import developer.task.structureXML.output.User;
import lombok.SneakyThrows;
import task7.RuntimeExceptionImp;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SingleFileProcesser implements Runnable {

    private final String readFiles = "/read-files";
    private final Pattern patternReadFiles = Pattern.compile(readFiles + "(/|$)");
    private final Pattern patternFileName = Pattern.compile("^file\\d+\\.xml", Pattern.CASE_INSENSITIVE);

    private Path pathFile;
    private List<User> users;

    public SingleFileProcesser(Path pathFile, List<User> users) {
        this.pathFile = pathFile;
        this.users = users;
    }


    @SneakyThrows
    @Override
    public void run() {
        if (!checkPath(pathFile)) {
            return;
        }
        processData();
//        moveFile();
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
//        String fileName = "/avg_" + file.getName();
//        String absolutePath = file.getParentFile().getAbsolutePath().replace("\\", "/");
//        String pathFile = absolutePath + fileName;

        // TODO: 11/18/19 тебе следует собрать сначала данные в общий котел, к которому организовать синхронный доступ, и потом отдельной службой выводить с него данные в отчет. Я этого не нашел, может плохо искал.
        // тут не понял что значит собрать в общий котел? сейчас у меня для каждого файла формируется отдельно выходной файл xml, каждый в своем потоке
        // TODO: 11/22/19 в этом и суть задания. Любое задание на многопоточность заключается не в том сможешь ли ты создать 10 процессов, которые выполняются параллельно,
        //  это не трудно. Задача в том чтобы эти процессы работали скоорденированно вокруг общего контейнера из которого они должны читать и писать в который, в этом 99,9% всех проблем
        //  с многопоточностью, вот когда получается 10 раз по  десять = 97. Поэтому отчет должен быть общей сводкой.
//        Output output = XMLParser.parseXMLWithMapper(file);
//        XMLWriter.writeXMLWithMapper(output, pathFile);
        List<User> usersList = XMLParser.parseXMLWithMapper(file);
        usersList.forEach(user -> users.add(user));
    }


    @SneakyThrows
    private void moveFile() {
        String absolutePath = pathFile.getParent().toAbsolutePath().toString().replace("\\", "/");
        String fileName = pathFile.getFileName().toString();

        String pathReadFile = absolutePath + readFiles;
        if (!checkFileAvailability(pathReadFile, true)) {
            throw new RuntimeExceptionImp("can't create directory");
        }

        String oldPath = absolutePath + "/" + fileName;
        String newPath = pathReadFile + "/" + fileName;
        if (!checkFileAvailability(newPath, false)) {
            throw new RuntimeExceptionImp("can't create file");
        }

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
}
