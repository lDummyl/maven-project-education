package developer.task;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

@AllArgsConstructor
public class MonitoringLogFiles implements Runnable {

    private String pathFiles = "";

    @SneakyThrows
    @Override
    public void run() {
        Files.walkFileTree(Paths.get(pathFiles), new SimpleFileVisitorExt());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MonitoringLogFiles("F:\\My knowledge\\Java\\Practice\\GitHub\\testWalk"));
        thread.start();
    }
}
