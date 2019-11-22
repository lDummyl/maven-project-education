package developer.task;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class FileMonitoringServiceTest {

    Logger log = Logger.getLogger(FileMonitoringServiceTest.class.getName());

    String path = "./developer-task-logs";

    // TODO: 11/18/19 тесты тесты тесты, нужен кейс где один и тот же юзер обрабатывется несколькими потоками и извстный результат подтверждается, то есть не искривляется асинхронностью.
    
    @SneakyThrows
    @Test
    public void runTest () {
        int countThread = 10;

        Thread thread = new Thread(new FileMonitoringService(path, countThread));
        thread.start();
        Thread.sleep(5000);

        boolean fileExists;

        fileExists = checkFileExists(path + "/file1.xml");
        assertFalse(fileExists);

        fileExists = checkFileExists(path + "/avg_file1.xml");
        assertTrue(fileExists);

        fileExists = checkFileExists(path + "/read-files/file1.xml");
        assertTrue(fileExists);
    }

    @SneakyThrows
    @Test
    public void someRunTest () {
        int countThread = 10;

        Thread threadOne = new Thread(new FileMonitoringService(path, countThread));
        Thread threadTwo = new Thread(new FileMonitoringService(path, countThread));

        threadOne.start();
        threadTwo.start();
        Thread.sleep(5000);

        boolean fileExists;

        fileExists = checkFileExists(path + "/some-test-folder/file21.xml");
        assertFalse(fileExists);

        fileExists = checkFileExists(path + "/some-test-folder/avg_file21.xml");
        assertTrue(fileExists);

        fileExists = checkFileExists(path + "/some-test-folder/read-files/file21.xml");
        assertTrue(fileExists);
    }

    private Boolean checkFileExists(String pathFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathFile));
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }
}