package developer.task;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.nio.file.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class FileMonitoringService implements Runnable {

    private String pathFile;
    private final int countThread;

    @SneakyThrows
    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(countThread);
        Path path = Paths.get(pathFile);
        WatchService watchService = getWatchService(path);

        while (true) {
            WatchKey watchKey = watchService.take();

            for (WatchEvent<?> event : watchKey.pollEvents()) {
                WatchEvent<Path> eventPath = (WatchEvent<Path>) event;
                String absolutePath = eventPath.context().toAbsolutePath().toString().replace("\\", "/");
                // не могу получить полный путь до файла. делаю это для file2.xml
                executorService.submit(new LogFilesMonitoring(absolutePath));
                Thread.sleep(3000);
            }

            if (!watchKey.reset()) {
                break;
            }
        }
    }

    @SneakyThrows
    private WatchService getWatchService(Path path) {
        WatchService watchService = path.getFileSystem().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);

        return watchService;
    }

    public static void main(String[] args) {
        String path = "target/developer-task-logs";
        int countThread = 10;

        Thread thread = new Thread(new FileMonitoringService(path, countThread));
        thread.start();
    }
}
