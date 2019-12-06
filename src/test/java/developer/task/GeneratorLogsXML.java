package developer.task;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @SneakyThrows
    private static Boolean clearPath(String pathDirectory) {
        try (Stream<Path> walk = Files.walk(Paths.get(pathDirectory))) {
            walk.forEach(path -> {
                File file = path.toFile();
                if (file.isFile()) {
                    file.delete();
                }
            });
        }

        return true;
    }

    @SneakyThrows
    private static void copyFile(Path oldPath, String toPath) {
        Path newPath = Paths.get(toPath.replace("\\", "/") + "/" + oldPath.getFileName());
        Files.copy(oldPath, newPath);
    }
}