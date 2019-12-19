package developer.task.XMLInteraction;

import developer.task.structureXML.input.Input;
import developer.task.structureXML.input.Log;
import developer.task.structureXML.output.supportClasses.UserIndicators;
import developer.task.structureXML.output.supportClasses.UserSite;
import lombok.Getter;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

@Getter
public class XMLParser {

    private Map<LocalDate, Map<UserSite, UserIndicators>> visitsMap = new HashMap<>();

    public void parseXMLWithMapper(File file) {
        Input input = XMLReader.readXMLWithMapper(file, Input.class);

        for (Log log : input.getLogs()) {
            writeUsersFromLog(log);
        }
    }

    public void writeUsersFromLog(Log log) {
        long startTime = log.getTimestamp();
        long timeSpent = log.getSeconds();

        LocalDateTime startDateTime = LocalDateTime.ofEpochSecond(startTime, 0, ZoneOffset.UTC);
        LocalDateTime endOfDay = LocalDateTime.of(startDateTime.toLocalDate(), LocalTime.MAX);
        long secondsToEndDay = Duration.between(startDateTime, endOfDay).getSeconds();

        long timeSpentOnDay = timeSpent;
        while (timeSpentOnDay > 0) {
            timeSpentOnDay = timeSpent - secondsToEndDay;
            if (timeSpentOnDay <= 0) {
                addUserInMap(startDateTime.toLocalDate(), log.getUserId(), log.getUrl(), timeSpent);
            } else {
                addUserInMap(startDateTime.toLocalDate(), log.getUserId(), log.getUrl(), secondsToEndDay);
                timeSpent -= secondsToEndDay;

                startDateTime = startDateTime.plusDays(1L);
                endOfDay = endOfDay.plusDays(1L);
                secondsToEndDay = Duration.between(startDateTime, endOfDay).getSeconds();
            }
        }
    }

    private void addUserInMap(LocalDate date, String userId, String url, Long timeSpent) {
        UserSite userSite = new UserSite(userId, url);

        Map<UserSite, UserIndicators> user = visitsMap.get(date);
        if (user != null) {
            UserIndicators userIndicators = user.get(userSite);
            if (userIndicators != null) {
                userIndicators.timeSpent += timeSpent;
                userIndicators.visitQuantity++;
            } else {
                user.put(userSite, new UserIndicators(timeSpent));
            }
        } else {
            Map<UserSite, UserIndicators> newSiteIndicators = new HashMap<>();
            newSiteIndicators.put(userSite, new UserIndicators(timeSpent));
            visitsMap.put(date, newSiteIndicators);
        }
    }
}
