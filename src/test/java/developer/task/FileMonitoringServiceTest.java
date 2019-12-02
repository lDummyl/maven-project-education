package developer.task;

import lombok.SneakyThrows;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class FileMonitoringServiceTest {

    Logger log = Logger.getLogger(FileMonitoringServiceTest.class.getName());

    String fromPath = "./src/test/java/logs_input";
    String path = "./developer-task-logs/log-files";
    String pathReport = "./developer-task-logs/report-files";
    String schemaFile = "input-validate.xsd";

    Path pathReportFile = Paths.get(pathReport);
    Pattern pattern = Pattern.compile("report_.+\\.xml");

    @SneakyThrows
    @Test
    public void runTest () {
        int countThread = 10;

        GeneratorLogsXML.transferLogFiles(fromPath, path);

        Thread thread = new Thread(new FileMonitoringService(path, pathReport, schemaFile, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();

        String pathNewFile = getNewFile(pathReportFile);

        assertNotEquals("", pathNewFile);
        assertTrue(checkFileExists(path + "/file1.xml"));
//        assertTrue(compareContentFiles("./developer-task-logs/report_pattern1.xml", pathNewFile));
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

    @SneakyThrows
    private Boolean compareContentFiles(String pathPatternFile, String pathNewFile) {
        Path patternPath = Paths.get(pathPatternFile);
        Path newPath = Paths.get(pathNewFile);

        List<String> patternPathLines = Files.readAllLines(patternPath);
        List<String> newPathLines = Files.readAllLines(newPath);

        StringBuilder patternSB = new StringBuilder();
        StringBuilder newPathSB = new StringBuilder();

        patternPathLines.forEach(patternSB::append);
        newPathLines.forEach(newPathSB::append);

        return patternSB.toString().equals(newPathSB.toString());
    }
}
