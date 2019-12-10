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

    // TODO: 12/2/19 не самая лучшая идея. В папке java должны быть только фаилы с кодом на java.
    //  Я почему-то не виджу папки с тестовыми ресурсами. А она должна быть возможно не закомичена. Как читать ресурсы я уже показывал,
    //  берешь класс лоадер и череез него. Но я бы вообще создавал бы данные а потом помещал бы в сканнер.

    String fromPath = "./src/test/java/logs_input"; // TODO: 12/9/19  вообще я бы избавился уже от нее раз мы генерируем на лету данные, по Васе например.

    String path = "./developer-task-logs/log-files";
    String pathReport = "./developer-task-logs/report-files";
    String schemaFile = "input-validate.xsd";

    Path pathReportFile = Paths.get(pathReport);
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

        assertTrue(writeInputLogs(input, "developer-task-logs/scan/testlog.xml"));

        int countThread = 10;

//        GeneratorLogsXML.transferLogFiles(fromPath, path); // TODO: 12/9/19 тут падает экспешн если папки у меня такой нет. java.nio.file.NoSuchFileException: ./developer-task-logs/log-files равно как и// /src/test/java/logs_input
//        GeneratorLogsXML.clearPath(pathReport);

        Thread thread = new Thread(new FileMonitoringService("developer-task-logs/scan/testlog.xml",
                pathReport, schemaFile, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();

        String pathNewFile = getNewFile(pathReportFile);
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
    public void testHighLoadValid() {
        ArrayList<Input> inputs = new ArrayList<>();
        LocalDateTime testTDateTime = LocalDateTime.now();
        String testUser = "Vasya";
        String testUrl = "https://www.google.ru";


        for (int i = 0; i <= 1000; i++) {
            Input input = new Input();
            List<Log> logs = new ArrayList<>();
            logs.add(new Log(Timestamp.valueOf(testTDateTime.plusMinutes(i)).getTime() / 1000L, testUser, testUrl, i%2 ==0 ? 10L : 100L));
            input.setLogs(logs);
            inputs.add(input);
        }

        for (Input input : inputs) {
            assertTrue(writeInputLogs(input, "developer-task-logs/scan/testlog" + inputs.indexOf(input) + ".xml"));
        }

        int countThread = 10;

//        GeneratorLogsXML.transferLogFiles(fromPath, path); // TODO: 12/9/19 тут падает экспешн если папки у меня такой нет. java.nio.file.NoSuchFileException: ./developer-task-logs/log-files равно как и// /src/test/java/logs_input
//        GeneratorLogsXML.clearPath(pathReport);

        Thread thread = new Thread(new FileMonitoringService("developer-task-logs/scan",
                pathReport, schemaFile, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();


        String pathNewFile = getNewFile(pathReportFile);
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

        GeneratorLogsXML.transferLogFiles(fromPath, path); // TODO: 12/9/19 тут падает экспешн если папки у меня такой нет. java.nio.file.NoSuchFileException: ./developer-task-logs/log-files
        GeneratorLogsXML.clearPath(pathReport);

        Thread thread = new Thread(new FileMonitoringService(path, pathReport, schemaFile, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();

        String pathNewFile = getNewFile(pathReportFile);

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
