package developer.task;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class LogFilesMonitoring implements Runnable {

    private Path pathFiles;

    public LogFilesMonitoring(Path pathFiles) {
        this.pathFiles = pathFiles;
    }

    public LogFilesMonitoring(String pathFiles) {
        this.pathFiles = Paths.get(pathFiles);
    }

    @SneakyThrows
    @Override
    public void run() {
        Files.walkFileTree(pathFiles, new SimpleFileVisitorExt());
    }


// TODO: 11/15/19  Зачем тебе 2 метода main? Почему не используешь способ чтения ресурсов, которые я привел? Почему нет никаких тестов?
//  За 15 минут прочитать код и понять как он работет может только компилятор. Человек этого делать не будет. One Issue at a time. Если есть проблема напиши тест кейс, который валится.
//  Тогда тебе можно будет помочь. Пока я могу только сказать почему программа не запускается, но я сделал это уже 11.10.19

    @SneakyThrows
    public static void main(String[] args) {
        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("text.txt");
        String myString = IOUtils.toString(Objects.requireNonNull(resource), "UTF-8");
        System.out.println(myString);

        Thread thread = new Thread(new LogFilesMonitoring("target/developer-task-logs"));  // TODO: 11/5/19 как ты понимаешь у меня этот путь работать не будет, перенеси в ресурсы проекта
        // ресурсы не читаются почему-то, еще с прошлых задач по этому проекту
        thread.start();
    }
}
