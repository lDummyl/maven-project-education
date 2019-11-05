package developer.task;

import developer.task.XMLInteraction.XMLParser;
import developer.task.XMLInteraction.XMLWriter;
import developer.task.structureXML.output.Output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class SimpleFileVisitorExt extends SimpleFileVisitor<Path> {

    private final String PATTERN_XML = "glob:{file}[0-9].xml";
    private final PathMatcher matcher;

    protected SimpleFileVisitorExt() {
        super();
        matcher = FileSystems.getDefault().getPathMatcher(PATTERN_XML);
    }

    @Override
    public FileVisitResult visitFile(Path pathFile, BasicFileAttributes attrs) throws IOException {
        if (!checkPath(pathFile)) {
            return FileVisitResult.CONTINUE;
        }

        File file = pathFile.toFile();
        if (file.canWrite()) {
            new FileOutputStream(file, true); // TODO: 11/5/19 try-with resources
            processData(file);
        }

        return FileVisitResult.CONTINUE;
    }

    private Boolean checkPath(Path pathFile) {
        if (!Files.isRegularFile(pathFile)) {
            return false;
        } else return matcher.matches(pathFile.getFileName());

    }

    private void processData(File file) {
        String fileName = "/avg_" + file.getName();
        String absolutePath = file.getParentFile().getAbsolutePath().replace("\\", "/");
        String pathFile = absolutePath + fileName;

        Output output = XMLParser.parseXMLWithMapper(file);
        XMLWriter.writeXMLWithMapper(output, pathFile);
    }
}
