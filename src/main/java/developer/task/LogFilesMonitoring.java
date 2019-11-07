package developer.task;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

@AllArgsConstructor
public class LogFilesMonitoring implements Runnable {

    private String pathFiles = "";

    @SneakyThrows
    @Override
    public void run() {
        Files.walkFileTree(Paths.get(pathFiles), new SimpleFileVisitorExt());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new LogFilesMonitoring("target/developer-task-logs"));  // TODO: 11/5/19 как ты понимаешь у меня этот путь работать не будет, перенеси в ресурсы проекта
                // ресурсы не читаются почему-то, еще с прошлых задач по этому проекту
        thread.start();
    }
}
