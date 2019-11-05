package developer.task.XMLInteraction;

import developer.task.structureXML.input.Input;
import developer.task.structureXML.input.Log;
import developer.task.structureXML.output.LogDay;
import developer.task.structureXML.output.Output;
import developer.task.structureXML.output.User;
import lombok.SneakyThrows;
import lombok.Synchronized;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XMLParser {

    @Synchronized
    public static List<User> parseXML(File file) {
        List<User> users = new ArrayList<>();

        Document document = XMLReader.readXML(file);
        NodeList elements = document.getElementsByTagName("log");

        for (int i = 0; i < elements.getLength(); i++) {
            Node node = elements.item(i);
            NodeList childElements = node.getChildNodes();
        }

        return users;
    }

    @Synchronized
    public static Output parseXMLWithMapper(File file) {
        Output output = parseXMLWithMapper_Input(file);
        return output;
    }

    private static Output parseXMLWithMapper_Input(File file) {
        Input input = XMLReader.readXMLWithMapper(file, Input.class);
        List<User> users = collectUsers(input);
        Output output = parseUsers(users);

        return output;
    }

    private static List<User> collectUsers(Input input) {
        List<User> users = new ArrayList<>();

        for (Log log : input.getLogs()) {
            User user = new User(log.getUserId(), log.getUrl());

            long startTime = log.getTimestamp();
            long endTime = startTime + log.getSeconds();
            long iterationTime = log.getTimestamp();
            while (iterationTime <= endTime) {
                LocalDateTime startDateTime = LocalDateTime.ofEpochSecond(startTime, 0, ZoneOffset.UTC);
                LocalDateTime iterationDateTime = LocalDateTime.ofEpochSecond(iterationTime, 0, ZoneOffset.UTC);
                long average = iterationTime - startTime;

                if (iterationTime == endTime) {
                    addUser(users, user, startDateTime, average);
                } else if (iterationDateTime.getDayOfYear() != startDateTime.getDayOfYear()) {
                    addUser(users, user, startDateTime, average);
                    user = new User(log.getUserId(), log.getUrl());
                    startTime = iterationTime;
                }

                iterationTime++;
            }
        }

        return users;
    }

    private static void addUser(List<User> users, User user, LocalDateTime date, long average) {
        user.setDate(date.toLocalDate());
        user.setAverage(average);
        users.add(user);
    }

    private static Output parseUsers(List<User> users) {
        Output output = new Output();

        Function<User, LocalDate> similarDates = User::getDate;
        Map<LocalDate, List<User>> dateListUsers = users.stream()
                .collect(Collectors.groupingBy(similarDates));
        dateListUsers.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(i -> output.getLogDays().add(new LogDay(i.getKey().toString(), i.getValue())));

        return output;
    }

    public static void main(String[] args) {
        File file = new File("target/logs/file1.xml");
//        List<User> usersAlso = parseXML("target/logs/file1.xml");
        Output output = parseXMLWithMapper(file);
        System.out.println(file.getParentFile().getAbsolutePath().replace("\\", "/"));
    }

    @SneakyThrows
    public static void mainTest(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        final Set<String> threadNames = new HashSet<>();
        int[] ass = {0};
//        ass = new int[]{99};
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                String name = Thread.currentThread().getName();
                System.out.println(name);
                threadNames.add(name);
                System.out.println(ass[0]++);
            });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(3000);
        }

        System.out.println(threadNames.size());
        System.out.println(threadNames);
    }
}
