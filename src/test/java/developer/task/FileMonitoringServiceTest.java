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

    String path = "./developer-task-logs";
    Path pathFile = Paths.get(path);
    Pattern pattern = Pattern.compile("report_.+\\.xml");

    @SneakyThrows
    @Test
    public void runTest () {
        int countThread = 10;

        Thread thread = new Thread(new FileMonitoringService(path, countThread, Duration.ofSeconds(3)));
        thread.start();
        thread.join();

        String pathNewFile = getNewFile(pathFile);

        assertNotEquals("", pathNewFile);
        assertFalse(checkFileExists(path + "/file1.xml"));
        assertTrue(checkFileExists(path + "/read-files/file1.xml")); // TODO: 11/27/19 у меня падает этот
        assertTrue(compareContentFiles(path + "/valid-files/report_pattern1.xml", pathNewFile));
        //TODO: последний асерт почему-то не работает с SneakyThrows, а если join запихнуть в трай и убрать SneakyThrows - то тест проходит
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
