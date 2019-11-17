package developer.task;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.logging.Logger;

public class FileMonitoringServiceTest {

    Logger log = Logger.getLogger(FileMonitoringServiceTest.class.getName());

    @SneakyThrows
    @Test
    public void runTest () {
        // TODO: тест проходит, но по факту он в потоке падает и ошибку не выдает. а через main в классе "FileMonitoringService" все работает нормально. С чем это связанно?
        String path = "./developer-task-logs";
        int countThread = 10;

        Thread thread = new Thread(new FileMonitoringService(path, countThread));
        thread.start();
    }
}