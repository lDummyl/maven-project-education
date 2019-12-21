package developer.task;

import developer.task.structureXML.input.Input;
import developer.task.structureXML.input.Log;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class GeneratorLogsXML {

    private static Random random = new Random();

    public static List<Input> createLogFiles(String path, int countFiles, int countUsersInFile, List<String> siteList) {
        List<Input> inputs = new ArrayList<>();
        for (int i = 0; i < countFiles; i++) {
//            String pathFile = path + "/part" + i;
//            createPath(pathFile, true);

            Input input = new Input();
            List<Log> logs = new ArrayList<>();
            for (int j = 0; j < countUsersInFile; j++) {
                LocalDateTime date = LocalDateTime.now();
                for (String site : siteList) {
                    date = date.plusMinutes(30);
                    Long timestamp = Timestamp.valueOf(date).getTime() / 1000L;
                    String userId = "user" + j;
//                    Long seconds = 100L;
                    Log log = new Log(timestamp, userId, site, 100L);
                    logs.add(log);
                }
            }
            input.setLogs(logs);
            inputs.add(input);
        }
        return inputs;
    }

    @SneakyThrows
    public static Boolean transferLogFiles(String fromPath, String toPath) {
        if (!clearPath(toPath)) {
            return false;
        }

        try (Stream<Path> walk = Files.walk(Paths.get(fromPath))) {
            walk.filter(p -> p.toFile().getName().endsWith(".xml"))
                    .forEach(path -> copyFile(path, toPath));
        }

        return true;
    }

    public static Boolean clearPath(String pathDirectory) {
        try (Stream<Path> walk = Files.walk(Paths.get(pathDirectory))) {
            walk.forEach(path -> {
                File file = path.toFile();
                if (file.isFile()) {
                    file.delete();
                }
            });
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static Boolean createPaths(List<String> paths, boolean isDirectory) {
        boolean allPresent = false;
        for (String path : paths) {
            allPresent = createPath(path, isDirectory);
        }
        return allPresent;
    }

    public static Boolean createPath(String path, boolean isDirectory) {
        File file = new File(path);
        if (isDirectory) {
            return file.mkdirs();
        } else {
            return file.getParentFile().mkdirs();
        }
    }

    @SneakyThrows
    private static void copyFile(Path oldPath, String toPath) {
        Path newPath = Paths.get(toPath.replace("\\", "/") + "/" + oldPath.getFileName());
        Files.copy(oldPath, newPath);
    }
}
