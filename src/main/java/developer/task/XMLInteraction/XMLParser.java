package developer.task.XMLInteraction;

import developer.task.structureXML.input.Input;
import developer.task.structureXML.input.Log;
import developer.task.structureXML.output.supportClasses.UserSite;
import lombok.Getter;

import java.io.File;
import java.time.*;
import java.util.*;

@Getter
public class XMLParser {

    private Map<UserSite, Map<LocalDate, Long>> userSiteMap = new HashMap<>();

    public void parseXMLWithMapper(File file) {
        Input input = XMLReader.readXMLWithMapper(file, Input.class);

        for (Log log : input.getLogs()) {
            writeUsersFromLog(log);
        }
    }

    public void writeUsersFromLog(Log log) {
        Map<LocalDate, Long> timeSpentFromLog = getTimeSpentAtDate(log.getTimestamp(), log.getSeconds());

        // TODO: тут жопа. в этот момент надо уже считать "visitQuantity", а как его тут счтитать я хз. Сейчас получается что всегда "visitQuantity" всегда 1
        UserSite userSite = new UserSite(log.getUserId(), log.getUrl());
        Map<LocalDate, Long> timeSpentPart = userSiteMap.get(userSite);
        if ( timeSpentPart == null) {
            userSiteMap.put(userSite, timeSpentFromLog);
        } else {
            for (Map.Entry<LocalDate, Long> entry : timeSpentFromLog.entrySet()) {
                Long timeSpent = timeSpentPart.get(entry.getKey());
                if (timeSpent == null) {
                    timeSpentPart.put(entry.getKey(), entry.getValue());
                } else {
                    timeSpentPart.put(entry.getKey(), entry.getValue() + timeSpent);
                }
//                timeSpentPart.merge(entry.getKey(), entry.getValue(), Long::sum);
            }
        }
    }

    private Map<LocalDate, Long> getTimeSpentAtDate(Long startTime, Long timeSpent) {
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
