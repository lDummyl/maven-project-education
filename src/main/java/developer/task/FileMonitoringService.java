package developer.task;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class FileMonitoringService implements Runnable {

    private final int countThread;
    private String pathFile;

    public FileMonitoringService(String pathFile, int countThread) {
        this.pathFile = pathFile.replace("\\", "/");
        this.countThread = countThread;
    }

    @NonNull
    public FileMonitoringService(URI pathFile, int countThread) {
        this(pathFile.getPath(), countThread);
    }

    @SneakyThrows
    @NonNull
    public FileMonitoringService(URL pathFile, int countThread) {
        this.pathFile = pathFile.toURI().getPath();
        this.countThread = countThread;
    }

    public static void main(String[] args) {
        String path = "./developer-task-logs";
        int countThread = 10;

        Thread thread = new Thread(new FileMonitoringService(path, countThread));
        thread.start();
    }

    @SneakyThrows
    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(countThread);
        Path path = Paths.get(pathFile);

        while (true) {
            try (Stream<Path> walk = Files.walk(path)) {
                walk.forEach(i -> executorService.submit(new SingleFileProcesser(i)));
            }
            Thread.sleep(3000);
        }
    }
}
