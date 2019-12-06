package developer.task;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
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
import java.io.IOException;
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

    // TODO: 12/2/19 не самая лучшая идея. В папке java должны быть только фаилы с кодом на java.
    //  Я почему-то не виджу папки с тестовыми ресурсами. А она должна быть возможно не закомичена. Как читать ресурсы я уже показывал,
    //  берешь класс лоадер и череез него. Но я бы вообще создавал бы данные а потом помещал бы в сканнер.

    String fromPath = "./src/test/java/logs_input";

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
        Log log1 = new Log(Timestamp.valueOf(testTDateTime).getTime(), testUser, testUrl, 100L);
        Log log2 = new Log(Timestamp.valueOf(testTDateTime.plusMinutes(15)).getTime(), testUser, testUrl, 10L);
        List<Log> logs = ImmutableList.of(log1, log2);
        input.setLogs(logs);
        // TODO: 12/2/19 дальше обжект маппер -> в фаилы, в папку сканнера, потом парсим резульатат и пишем ассерт что по юзеру Vasya за сегодня среднне время на гугле 55 сек.

        // Непонятная мне хрень вообще
        // 1. когда пишешь xml через "writeValue", где параметры (File, String), то в xml появляется верхний тег <String></String> - не знаю как его убрать
        // 2. так же при записи xml через тот же метод символ "<" заменяется сам на "&lt;"
        // эти два вопроса не дают сделать обратную конвертацию для теста
        // гуглил, яндексил и тд - решения не нашел
        assertTrue(writeInputLogs(input, "developer-task-logs/scan/testlog.xml"));
        removeExtraTags(fromPath + "/file4.xml", Arrays.asList("String"));

        int countThread = 10;

        GeneratorLogsXML.transferLogFiles(fromPath, path);

        Thread thread = new Thread(new FileMonitoringService(path + "/file4.xml", pathReport, schemaFile, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();

        String pathNewFile = getNewFile(pathReportFile);
        removeExtraTags(pathNewFile, Arrays.asList("String"));
        Output output = XMLReader.readXMLWithMapper(new File(pathNewFile), Output.class);

        LocalDate testDate = testTDateTime.toLocalDate();
        List<LogDay> logDays = output.getLogDays().stream().filter(i -> i.getDay().equals(testDate.toString())).collect(Collectors.toList());

        assertEquals(1, logDays.size());

        LogDay logDay1 = logDays.get(0);
        List<User> targetUser = logDay1.getUsers().stream().peek(u -> assertEquals(testDate, u.getDate()))
                .filter(u -> u.getUserId().equals(testUser) && u.getUrl().equals(testUrl)).collect(Collectors.toList());

        assertEquals(1, targetUser.size());
        assertEquals(55, targetUser.get(0).getAverage().intValue());


    }

    // TODO: 12/6/19 просто ты создал объект - строка содержащая хмл, и попытался этот строковый объект сериализовать,
    //  хотя твоя задача была сериализовать просто объект напрямую.
    @SneakyThrows
    private Boolean writeInputLogs(Input input, String pathFile) {
        File resultFile = new File(pathFile);
        if (!resultFile.createNewFile()){
            if(resultFile.delete()){
                writeInputLogs(input, pathFile);
            }else {
                throw new RuntimeException(pathFile + " cannot be deleted.");
            }
        }
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        xmlMapper.writeValue(resultFile, input);
        return true;
    }

    //    @SneakyThrows
    private void removeExtraTags(String pathFile, List<String> tags) {
        StringBuilder content = new StringBuilder();

//        Path path = Paths.get(pathFile);
        try {
            Files.readAllLines(Paths.get(pathFile)).forEach(str -> content.append(str));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String resultString = content.toString();
        for (String tag : tags) {
            resultString = resultString.replace("<" + tag + ">", "");
            resultString = resultString.replace("</" + tag + ">", "");
        }
        resultString = resultString.replace("&lt;", "<");

        File file = new File(pathFile);
//        if (file.exists() && file.delete()) {
//            file.createNewFile();
//        }

        try {
            xmlMapper.writeValue(file, resultString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Test
    public void runTest() {
        int countThread = 10;

        GeneratorLogsXML.transferLogFiles(fromPath, path);

        Thread thread = new Thread(new FileMonitoringService(path, pathReport, schemaFile, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();

        String pathNewFile = getNewFile(pathReportFile);

        assertNotEquals("", pathNewFile);
        assertTrue(checkFileExists(path + "/file1.xml"));
        //TODO: у меня проходит тест нормально
        // TODO: 11/29/19 да, но видишь ли это известный камень предкновения https://me.me/i/it-works-on-my-machine-then-well-ship-your-machine-77a416969b504b1ea2ce22f555b4d8f5
        //  потенциальный работодатель этот аргумент не оценит, он дебажить не будет, ему обычно некогда даже смотреть это задание.
        //  Я в свое время вообще проерял свое решение на левом компе перед отправкой чтобы избежать этих проблем
        //  вообще конечно 99% это потому что я на линуксе а ты на Винде. Учитывая что четверть вакансий на java включают в себя навыки работы под linux
        //  на твоем бы месте я б поставил себе ubuntu 19, лучше всего нарезать на своем винте сегмент гигов на 30 - 50 и привыкать
        //  так или иначе потребуется и Докер рано или поздно постигать и прочее.
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
