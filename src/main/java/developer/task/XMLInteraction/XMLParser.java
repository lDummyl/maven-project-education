package developer.task.XMLInteraction;

import developer.task.structureXML.input.Input;
import developer.task.structureXML.input.Log;
import developer.task.structureXML.output.LogDay;
import developer.task.structureXML.output.Output;
import developer.task.structureXML.output.User;
import lombok.Synchronized;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XMLParser {

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
}
