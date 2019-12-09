package developer.task.XMLInteraction;

import developer.task.structureXML.input.Input;
import developer.task.structureXML.input.Log;
import developer.task.structureXML.output.User;
import lombok.Synchronized;

import java.io.File;
import java.time.*;
import java.util.*;

public class XMLParser {

    @Synchronized
    public static List<User> parseXMLWithMapper(File file) {
        return parseXMLWithMapper_Input(file);
    }

    private static List<User> parseXMLWithMapper_Input(File file) {
        Input input = XMLReader.readXMLWithMapper(file, Input.class);
        return collectUsers(input);
    }

    private static List<User> collectUsers(Input input) {
        List<User> users = new ArrayList<>();

        for (Log log : input.getLogs()) {
            users.addAll(getUsersFromLog(log));
        }

        return users;
    }

    public static List<User> getUsersFromLog(Log log) {
        List<User> users = new ArrayList<>();

        Map<LocalDate, Long> timeSpentFromLog = getTimeSpentAtDate(log.getTimestamp(), log.getSeconds());
        timeSpentFromLog.entrySet().forEach(entry -> users.add(new User(entry.getKey(), log.getUserId(), log.getUrl(), entry.getValue())));

        return users;
    }

    private static Map<LocalDate, Long> getTimeSpentAtDate(Long startTime, Long timeSpent) {
        Map<LocalDate, Long> timeSpentFromLog = new HashMap<>();

        LocalDateTime startDateTime = LocalDateTime.ofEpochSecond(startTime, 0, ZoneOffset.UTC);
        LocalDateTime endOfDay = LocalDateTime.of(startDateTime.toLocalDate(), LocalTime.MAX);
        long secondsToEndDay = Duration.between(startDateTime, endOfDay).getSeconds();

        long timeSpentOnDay = timeSpent;
        while (timeSpentOnDay > 0) {
            timeSpentOnDay = timeSpent - secondsToEndDay;
            if (timeSpentOnDay <= 0) {
                timeSpentFromLog.put(startDateTime.toLocalDate(), timeSpent);
            } else {
                timeSpentFromLog.put(startDateTime.toLocalDate(), secondsToEndDay);
                timeSpent -= secondsToEndDay;

                startDateTime = startDateTime.plusDays(1L);
                endOfDay = endOfDay.plusDays(1L);
                secondsToEndDay = Duration.between(startDateTime, endOfDay).getSeconds();
            }
        }

        return timeSpentFromLog;
    }
}
