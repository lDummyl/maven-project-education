package developer.task;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@AllArgsConstructor
public class LogFilesMonitoring implements Runnable {

    private String pathFiles = "";

    @SneakyThrows
    public static void main(String[] args) {

        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("text.txt");
        String myString = IOUtils.toString(Objects.requireNonNull(resource), "UTF-8");
        System.out.println(myString);

        Thread thread = new Thread(new LogFilesMonitoring("target/developer-task-logs"));  // TODO: 11/5/19 как ты понимаешь у меня этот путь работать не будет, перенеси в ресурсы проекта
        // ресурсы не читаются почему-то, еще с прошлых задач по этому проекту
        thread.start();
    }

    @SneakyThrows
    @Override
    public void run() {
        Files.walkFileTree(Paths.get(pathFiles), new SimpleFileVisitorExt());
    }
}
