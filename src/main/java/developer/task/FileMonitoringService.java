package developer.task;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.URL;
import java.nio.file.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileMonitoringService implements Runnable {

    private String pathFile;
    private final int countThread;

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

    @SneakyThrows
    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(countThread);
        Path path = Paths.get(pathFile);

        for (int j = 0; j < 1; j++) {
            Files.walk(path).forEach(i -> executorService.submit(new LogFilesMonitoring(i)));
            Thread.sleep(3000);
        }
    }

    public static void main(String[] args) {
        String path = "./developer-task-logs";
        int countThread = 10;

        Thread thread = new Thread(new FileMonitoringService(path, countThread));
        thread.start();
    }
}
