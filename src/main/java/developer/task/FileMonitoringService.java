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
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileMonitoringService implements Runnable {

    private final int countThread;
    private String pathFile;
    private Duration ofMonitoring;
    private LocalDateTime creation = LocalDateTime.now();
    private List<User> users = Collections.synchronizedList(new ArrayList<>());

    public FileMonitoringService(String pathFile, int countThread, Duration ofMonitoring) {
        this.pathFile = pathFile.replace("\\", "/");
        this.countThread = countThread;
        this.ofMonitoring = ofMonitoring;
    }

    @NonNull
    public FileMonitoringService(URI pathFile, int countThread, Duration ofMonitoring) {
        this(pathFile.getPath(), countThread, ofMonitoring);
    }

    @SneakyThrows
    @NonNull
    public FileMonitoringService(URL pathFile, int countThread, Duration ofMonitoring) {
        this.pathFile = pathFile.toURI().getPath().replace("\\", "/");
        this.countThread = countThread;
        this.ofMonitoring = ofMonitoring;
    }

    public static void main(String[] args) {
        String path = "./developer-task-logs";
        int countThread = 10;

        Thread thread = new Thread(new FileMonitoringService(path, countThread, Duration.ofSeconds(3)));
        thread.start();
    }

    @SneakyThrows
    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(countThread);
        Path path = Paths.get(pathFile);

        while (creation.plus(ofMonitoring).isAfter(LocalDateTime.now())) {
            try (Stream<Path> walk = Files.walk(path)) {
                walk.forEach(i -> executorService.submit(new SingleFileProcesser(i, users)));
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
        String filePath = pathFile + "/report_" + getDateTimeFormat(LocalDateTime.now()) + ".xml";
        return XMLWriter.writeXMLWithMapper(parseUsers(), filePath);
    }

    private String getDateTimeFormat(LocalDateTime date) {
        return date.getYear() + "_" + date.getMonthValue() + "_" + date.getDayOfMonth() + "_"
                + date.getHour() + "_" + date.getMinute() + "_" + date.getSecond();
    }

    private Output parseUsers() {
        Output output = new Output();

        Function<User, LocalDate> similarDates = User::getDate;
        Map<LocalDate, List<User>> dateListUsers = users.stream()
                .collect(Collectors.groupingBy(similarDates));

        dateListUsers.entrySet().forEach(entry -> entry.setValue(groupUsers(entry.getValue())));

        List<LogDay> logDays = output.getLogDays();
        dateListUsers.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(i -> logDays.add(new LogDay(i.getKey().toString(), i.getValue())));

        return output;
    }

    private List<User> groupUsers(List<User> usersList) {
        List<User> newUsersList = new ArrayList<>();

        for (User user : usersList) {
            User iterationUser = null;
            for (User addedUser : newUsersList) {
                if (compareUsers(addedUser, user)) {
                    iterationUser = addedUser;
                }
            }

            if (iterationUser != null) {
                iterationUser.setTimeSpent(iterationUser.getTimeSpent() + user.getTimeSpent());
                iterationUser.setUserQuantity(iterationUser.getUserQuantity() + user.getUserQuantity());
            } else {
                newUsersList.add(new User(user.getDate(), user.getUserId(), user.getUrl(), user.getAverage(),
                        user.getTimeSpent(), user.getUserQuantity()));
            }
        }
        newUsersList.forEach(User::calculateAverage);

        usersList.clear();

        return newUsersList;
    }

    private Boolean compareUsers(User addedUser, User anotherUser) {
        return addedUser.getDate().isEqual(anotherUser.getDate()) &&
                addedUser.getUserId().equals(anotherUser.getUserId()) &&
                addedUser.getUrl().equals(anotherUser.getUrl());
    }
}
