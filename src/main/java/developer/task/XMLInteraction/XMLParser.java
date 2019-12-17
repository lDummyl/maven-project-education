package developer.task.XMLInteraction;

import developer.task.structureXML.input.Input;
import developer.task.structureXML.input.Log;
import developer.task.structureXML.output.supportClasses.UserIndicators;
import developer.task.structureXML.output.supportClasses.UserSite;
import lombok.Getter;

import java.io.File;
import java.time.*;
import java.util.*;

@Getter
public class XMLParser {

    // TODO: 12/15/19 любой черновик всегда можно переделать. Например, если у нас вывод сгруппирован по датам, возможно следует сделать
    //  группировку так Map<LocalDate, Map<UserSite, UserIndicators>> она будет похожа максимально на итоговый вывод.
    // так не получится, потому что Map<LocalDate, UserIndicators> собирается по одному логу и там может быть несколько дней

    private Map<UserSite, Map<LocalDate, UserIndicators>> userSiteMap = new HashMap<>();

    public void parseXMLWithMapper(File file) {
        Input input = XMLReader.readXMLWithMapper(file, Input.class);

        for (Log log : input.getLogs()) {
            writeUsersFromLog(log);
        }
    }

    public void writeUsersFromLog(Log log) {
        Map<LocalDate, UserIndicators> timeSpentFromLog = getTimeSpentAtDate(log.getTimestamp(), log.getSeconds());

        UserSite userSite = new UserSite(log.getUserId(), log.getUrl());
        Map<LocalDate, UserIndicators> timeSpentPart = userSiteMap.get(userSite);
        if ( timeSpentPart == null) {
            userSiteMap.put(userSite, timeSpentFromLog);
        } else {
            for (Map.Entry<LocalDate, UserIndicators> entry : timeSpentFromLog.entrySet()) {
                UserIndicators userIndicators = timeSpentPart.get(entry.getKey());
                if (userIndicators == null) {
                    timeSpentPart.put(entry.getKey(), entry.getValue());
                } else {
                    UserIndicators findUserIndicators = entry.getValue();
                    findUserIndicators.timeSpent += userIndicators.timeSpent;
                    findUserIndicators.visitQuantity += userIndicators.visitQuantity;
                    timeSpentPart.put(entry.getKey(), findUserIndicators);
                }
//                timeSpentPart.merge(entry.getKey(), entry.getValue(), Long::sum);
            }
        }
    }

    private Map<LocalDate, UserIndicators> getTimeSpentAtDate(Long startTime, Long timeSpent) {
        Map<LocalDate, UserIndicators> timeSpentFromLog = new HashMap<>();

        LocalDateTime startDateTime = LocalDateTime.ofEpochSecond(startTime, 0, ZoneOffset.UTC);
        LocalDateTime endOfDay = LocalDateTime.of(startDateTime.toLocalDate(), LocalTime.MAX);
        long secondsToEndDay = Duration.between(startDateTime, endOfDay).getSeconds();

        long timeSpentOnDay = timeSpent;
        while (timeSpentOnDay > 0) {
            timeSpentOnDay = timeSpent - secondsToEndDay;
            if (timeSpentOnDay <= 0) {
                timeSpentFromLog.put(startDateTime.toLocalDate(), new UserIndicators(timeSpent));
            } else {
                timeSpentFromLog.put(startDateTime.toLocalDate(), new UserIndicators(secondsToEndDay));
                timeSpent -= secondsToEndDay;

                startDateTime = startDateTime.plusDays(1L);
                endOfDay = endOfDay.plusDays(1L);
                secondsToEndDay = Duration.between(startDateTime, endOfDay).getSeconds();
            }
        }

        return timeSpentFromLog;
    }
}
