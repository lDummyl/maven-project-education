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

    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(countThread);
        Path path = Paths.get(pathFile);

        WatchKey watchKey = getWatchKey(path);
        // тут я не уверен что пошел по правильному пути, что-то не клеится
    }

    @SneakyThrows
    private WatchKey getWatchKey(Path path) {
        WatchService watchService = path.getFileSystem().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);

        return watchService.take();
    }
}
