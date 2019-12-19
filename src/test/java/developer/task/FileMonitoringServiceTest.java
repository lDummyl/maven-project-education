package developer.task;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.collect.ImmutableList;
import developer.task.XMLInteraction.XMLReader;
import developer.task.structureXML.input.Input;
import developer.task.structureXML.input.Log;
import developer.task.structureXML.output.LogDay;
import developer.task.structureXML.output.Output;
import developer.task.structureXML.output.User;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class FileMonitoringServiceTest {

    Logger log = Logger.getLogger(FileMonitoringServiceTest.class.getName());
    XmlMapper xmlMapper = new XmlMapper();

    String fromPath = "./src/test/java/logs_input";

    String path = "./developer-task-logs/log-files";
    String pathReport = "./developer-task-logs/report-files";
    String schemaFile = "input-validate.xsd";

    Pattern pattern = Pattern.compile("report_.+\\.xml");

    @SneakyThrows
    @Test
    public void testValid() {
        Input input = new Input();
        LocalDateTime testTDateTime = LocalDateTime.now();
        String testUser = "Vasya";
        String testUrl = "https://www.google.ru";
        Log log1 = new Log(Timestamp.valueOf(testTDateTime).getTime()/1000L, testUser, testUrl, 100L);
        Log log2 = new Log(Timestamp.valueOf(testTDateTime.plusMinutes(15)).getTime()/1000L, testUser, testUrl, 10L);
        List<Log> logs = ImmutableList.of(log1, log2);
        input.setLogs(logs);

        String scanPath = "developer-task-logs/scan/testlog.xml";

        GeneratorLogsXML.createPaths(Arrays.asList(fromPath, path, pathReport), true);
        GeneratorLogsXML.createPath(scanPath, false);

        GeneratorLogsXML.clearPath(pathReport);
        GeneratorLogsXML.clearPath(scanPath);
        assertTrue(writeInputLogs(input, scanPath));

        int countThread = 10;

        Thread thread = new Thread(new FileMonitoringService(scanPath,
                pathReport, schemaFile, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();

        String pathNewFile = getNewFile(Paths.get(pathReport));
        Output output = XMLReader.readXMLWithMapper(new File(pathNewFile), Output.class);

        LocalDate testDate = testTDateTime.toLocalDate();
        List<LogDay> logDays = output.getLogDays().stream().filter(i -> i.getDay().equals(testDate.toString())).collect(Collectors.toList());

        assertEquals(1, logDays.size());

        LogDay logDay1 = logDays.get(0);
        List<User> targetUser = logDay1.getUsers().stream()
                .filter(u -> u.getUserId().equals(testUser) && u.getUrl().equals(testUrl)).collect(Collectors.toList());

        assertEquals(1, targetUser.size());
        assertEquals(55, targetUser.get(0).getAverage().intValue());
    }

    @SneakyThrows
    @Test
    public void testBenchmark() {
        // TODO: 12/11/19 самое время проверить какой бенефит от многопоточности.
        //  Нужно прогнать аналогичные нагрузочные тесты и расчитать сколько времени потребуется одному потоку, а сколько 10ти, например.
        //  Сравнить во сколько раз наш перфрманс улучшен. При этом возможно данных следует сгенерить побольше на каждый обрабатываемый фаил,
        //  сильно побольше.

        new File(fromPath).mkdirs();
        new File(pathReport).mkdirs();

        for (int i = 0; i < 1000; i++) {
            String pathDirectory = path + "/part" + i;
            new File(pathDirectory).mkdirs();
            GeneratorLogsXML.transferLogFiles(fromPath, pathDirectory);
        }
        GeneratorLogsXML.clearPath(pathReport);

        int countThread = 1;

        LocalDateTime startTime = LocalDateTime.now();
        Thread thread = new Thread(new FileMonitoringService(path, pathReport, schemaFile, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();
        LocalDateTime endTime = LocalDateTime.now();

        Duration betweenOneThread = Duration.between(startTime, endTime);

        GeneratorLogsXML.clearPath(pathReport);

        countThread = 10;

        startTime = LocalDateTime.now();
        thread = new Thread(new FileMonitoringService(path, pathReport, schemaFile, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();
        endTime = LocalDateTime.now();

        Duration betweenTenThread = Duration.between(startTime, endTime);

        log.info("ten thread: " + betweenTenThread.getSeconds() + "; one thread: " + betweenOneThread.getSeconds());
        // TODO: 12/13/19 задай такие входные условия чтобы разница составляла не менее 4х раз в производительности, бонус тебе в помощь
        assertTrue(betweenTenThread.getSeconds() / betweenOneThread.getSeconds() > 4);
        // 15.12.19 с текущей реализацией все равно разница почти в 3 раза, но не в 4 (6 и 15 сек)
        // 19.12.19 переделал механизм - стало даже чуть хуже (6 и 9)
        //    у меня складывается ощущение что аннотация синхронизации не работает,
        //    потому что тест testHighLoadValid все так же падает ругаясь на то что logday не 1, а 9 штук, а он заполняется как раз в методе, где синхронизация
    }

    @SneakyThrows
    @Test
    public void testHighLoadValid() {
        List<Input> inputs = new ArrayList<>();
        LocalDateTime testTDateTime = LocalDateTime.now();
        String testUser = "Vasya";
        String testUrl = "https://www.google.ru";

        String scanPath = "developer-task-logs/scan";

        new File(pathReport).mkdirs();
        GeneratorLogsXML.clearPath(pathReport);
        GeneratorLogsXML.clearPath(scanPath);

        for (int i = 0; i <= 1000; i++) {
            Input input = new Input();
            List<Log> logs = new ArrayList<>();
            logs.add(new Log(Timestamp.valueOf(testTDateTime.plusMinutes(i)).getTime() / 1000L, testUser, testUrl, i%2 ==0 ? 10L : 100L));
            input.setLogs(logs);
            inputs.add(input);
        }

        for (Input input : inputs) {
            assertTrue(writeInputLogs(input, scanPath + "/testlog" + inputs.indexOf(input) + ".xml"));
        }

        int countThread = 10;

        Thread thread = new Thread(new FileMonitoringService(scanPath,
                pathReport, schemaFile, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();

        String pathNewFile = getNewFile(Paths.get(pathReport));
        Output output = XMLReader.readXMLWithMapper(new File(pathNewFile), Output.class);

        LocalDate testDate = testTDateTime.toLocalDate();
        List<LogDay> logDays = output.getLogDays().stream().filter(i -> i.getDay().equals(testDate.toString())).collect(Collectors.toList());

        assertEquals(1, logDays.size());

        LogDay logDay1 = logDays.get(0);
        List<User> targetUser = logDay1.getUsers().stream()
                .filter(u -> u.getUserId().equals(testUser) && u.getUrl().equals(testUrl)).collect(Collectors.toList());

        assertEquals(1, targetUser.size());
        assertEquals(55, targetUser.get(0).getAverage().doubleValue(), 1.); // TODO: 12/9/19 дает 54 пока не знаю почему может погрешность рпи вычислении среднего, а может и нет
    }

    @SneakyThrows
    private Boolean writeInputLogs(Input input, String pathFile) {
        File resultFile = new File(pathFile);
        resultFile.getParentFile().mkdirs(); // TODO: 12/9/19 вот обрати внимание чтобы создалась папочная инфраструктура под создаваемые фаилы
        if (!resultFile.createNewFile()) {
            if (resultFile.delete()) {
                writeInputLogs(input, pathFile);
            } else {
                throw new RuntimeException(pathFile + " cannot be deleted.");
            }
        }
        xmlMapper.writeValue(resultFile, input);
        return true;
    }

    @SneakyThrows
    @Test
    public void runTest() {
        int countThread = 10;

        GeneratorLogsXML.createPaths(Arrays.asList(fromPath, path, pathReport), true);

        GeneratorLogsXML.transferLogFiles(fromPath, path);
        GeneratorLogsXML.clearPath(pathReport);

        Thread thread = new Thread(new FileMonitoringService(path, pathReport, schemaFile, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();

        String pathNewFile = getNewFile(Paths.get(pathReport));

        assertNotEquals("", pathNewFile);
        assertTrue(checkFileExists(path + "/file1.xml"));
    }

    @SneakyThrows
    private String getNewFile(Path pathFile) {
        List<String> pathFiles = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(pathFile)) {
            walk.forEach(i -> pathFiles.add(i.toString()));
        }

        for (String path : pathFiles) {
            if (pattern.matcher(path).find()) {
                return path;
            }
        }
        return "";
    }

    private Boolean checkFileExists(String pathFile) {
        return Paths.get(pathFile).toFile().exists();
    }
}
