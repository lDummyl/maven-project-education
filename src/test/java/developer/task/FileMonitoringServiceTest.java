package developer.task;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
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

        Thread thread = new Thread(new FileMonitoringService(path, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();

        boolean fileExists; // TODO: 11/26/19 старайся не переиспользовать переменную, вообще никогда. Все делать final не обязательно,
        //                      но представить что они final очень полезно, в данном случае можно просто все выражение поместить в блок assert

        fileExists = checkFileExists(path + "/file1.xml");
        assertFalse(fileExists);

        fileExists = checkFileExists(path + "/read-files/file1.xml");
        assertTrue(fileExists);

        // TODO: 11/26/19 я бы сделал так, создал бы исходные фаилы на основании данных в тесте, сохранил их как отчеты через маппер, запустил бы сканирование,
        //  и проверил содержимое распарсив эти фаилы и сопоставив данные. Просто ассерты на то что фаилы созданы ничего не говорят об их содержании.
    }

    @SneakyThrows
    @Test
    public void someRunTest () {
        int countThread = 10;

        // TODO: 11/22/19 зачем тебе 2 мониторинга? Один прораб ходит по всем папкам и каждый фаил отдает другому потоку,
        //  который обрабатывает его и данные добавляет в общий котел. после завершения периода сканирования мы выводим общий результат.

        Thread thread = new Thread(new FileMonitoringService(path, countThread, Duration.ofSeconds(3)));
        thread.start();
    }


    // TODO: 11/26/19 зря проигнорировал и удалил эту строчку
    //  (Paths.get(path + "/some-test-folder/avg_file21.xml").toFile().exists());

    private Boolean checkFileExists(String pathFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathFile));
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }
}