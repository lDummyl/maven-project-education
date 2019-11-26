package developer.task;

import developer.task.XMLInteraction.XMLParser;
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
        if (!isFileValid(pathFile)) {
            return;
            // TODO: 11/27/19 а ведь я в коммите  3c50fbb5cabd2183c4474046df2dc30f19227378 предупреждал что не надо так делать.
            //  Не знаю что не так с последним ассертом у меня тест дальше этого блока не идет ¯\_(ツ)_/¯ а чтобы понять это пришлось дебажить, тратить время
        }
        processData();
        moveFile();
    }

    private Boolean isFileValid(Path pathFile) {
        String absolutePath = pathFile.toAbsolutePath().toString().replace("\\", "/");


        // TODO: 11/27/19 что-то с регулярочками не так, и зачем тебе их тащить матчеры, а потом вызывать, не лучше ли сразу присвоить boolean
        //  это будет гораздо более читаемый код, потому как название boolean переменной всегда позволяет дать в качестве имени вопрос на кторый мы отвечаем.
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
