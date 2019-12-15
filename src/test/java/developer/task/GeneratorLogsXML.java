package developer.task;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class GeneratorLogsXML {

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
