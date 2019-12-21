package developer.task;

import developer.task.XMLInteraction.XMLWriter;
import developer.task.structureXML.output.LogDay;
import developer.task.structureXML.output.Output;
import developer.task.structureXML.output.User;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class FileMonitoringService implements Runnable {

    private final int countThread;
    private String pathFile;
    private String pathReportFile;
    private String schemaFile;
    private Duration ofMonitoring;
    private LocalDateTime creation = LocalDateTime.now();
    private Map<LocalDate, List<User>> outputMap = new HashMap<>();

    public FileMonitoringService(String pathFile, String pathReportFile, String schemaFile, int countThread, Duration ofMonitoring) {
        this.pathFile = pathFile.replace("\\", "/");
        this.pathReportFile = pathReportFile.replace("\\", "/");
        this.schemaFile = schemaFile;
        this.countThread = countThread;
        this.ofMonitoring = ofMonitoring;
    }

    @NonNull
    public FileMonitoringService(URI pathFile, URI pathReportFile, URI schemaFile, int countThread, Duration ofMonitoring) {
        this(pathFile.getPath(), pathReportFile.getPath(), schemaFile.getPath(), countThread, ofMonitoring);
    }

    @SneakyThrows
    @NonNull
    public FileMonitoringService(URL pathFile, URL pathReportFile, URL schemaFile, int countThread, Duration ofMonitoring) {
        this.pathFile = pathFile.toURI().getPath().replace("\\", "/");
        this.pathReportFile = pathReportFile.toURI().getPath().replace("\\", "/");
        this.schemaFile = schemaFile.toURI().getPath().replace("\\", "/");
        this.countThread = countThread;
        this.ofMonitoring = ofMonitoring;
    }

    @SneakyThrows
    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(countThread);
        Path path = Paths.get(pathFile);

        while (creation.plus(ofMonitoring).isAfter(LocalDateTime.now())) {
            try (Stream<Path> walk = Files.walk(path)) {
                walk.filter(p -> p.toFile().getName().endsWith(".xml"))
                        .forEach(i -> executorService.submit(new SingleFileProcessor(i, schemaFile, outputMap)));
            }
            Thread.sleep(3000);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(3000);
        }

        writeFileXML();
    }

    private Boolean writeFileXML() {
        String filePath = pathReportFile + "/report_" + getDateTimeFormat(LocalDateTime.now()) + ".xml";
        Output output = getOutputFromMap();
        return XMLWriter.writeXMLWithMapper(output, filePath);
    }

    private String getDateTimeFormat(LocalDateTime date) {
        return date.getYear() + "_" + date.getMonthValue() + "_" + date.getDayOfMonth();
//                + "_" + date.getHour() + "_" + date.getMinute() + "_" + date.getSecond();
    }

    private Output getOutputFromMap() {
        Output output = new Output();
        for (Map.Entry<LocalDate, List<User>> entry : outputMap.entrySet()) {
            List<LogDay> logDays = output.getLogDays();
            logDays.add(new LogDay(entry.getKey().toString(), entry.getValue()));
        }
        return output;
    }
}
