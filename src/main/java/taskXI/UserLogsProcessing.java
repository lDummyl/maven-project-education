package taskXI;

import java.io.File;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserLogsProcessing implements LogsFinder, StAXParserInputFiles {

    public List <UserLogs> createUserLogsList() {
        //обработка логов потоками, try-catch блок в случае прерывания (чтобы хотя бы часть объектов была создана
        //и попала в исходящий файл-отчет
        List <UserLogs> userLogsList = new ArrayList<>();
        List<File> list = findLogs("C:\\java\\logs");
        for (File file : list) {
            userLogsList.addAll(StAXParserInputFiles.super.createUserLogs(file));
        }
        return userLogsList;

    }


    public LocalDateTime getStartDateTime(UserLogs userLogs) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(userLogs.unixTime), ZoneOffset.UTC);
    }

    public LocalDateTime getEndDateTime(UserLogs userLogs) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(userLogs.unixTime).plusSeconds(userLogs.getQtySecondsUserSpend()), ZoneOffset.UTC);
    }

    public Map<OutgoingFile, LocalDate> getFileForOut(List<UserLogs> list) {
        HashMap<OutgoingFile, LocalDate> map = new HashMap<>();
        List <OutgoingFile> outgoingFiles = new ArrayList<>();
        for (UserLogs userLogs : list) {
            LocalDateTime startDateTime = getStartDateTime(userLogs);
            LocalDateTime endDateTime = getEndDateTime(userLogs);
            LocalDate startDate = startDateTime.toLocalDate();
            LocalDate endDate = endDateTime.toLocalDate();
            LocalTime endTimeOfSession = endDateTime.toLocalTime();
            if (startDate.equals(endDate)) {
                map.put(new OutgoingFile(userLogs.getUserID(), userLogs.getUrl(), userLogs.getQtySecondsUserSpend()), startDate);
            } else
            {
                LocalTime midnight = LocalTime.MIDNIGHT;
                long secondsAfterMidnight = Duration.between(midnight, endTimeOfSession).toSeconds();
                map.put(new OutgoingFile(userLogs.getUserID(), userLogs.getUrl(), secondsAfterMidnight),endDate);
                long secondsBeforeMidnight = userLogs.getQtySecondsUserSpend() - secondsAfterMidnight;
                map.put(new OutgoingFile(userLogs.getUserID(), userLogs.getUrl(), secondsBeforeMidnight), startDate);
            }
        }
        return map;
    }


    @Override
    public void writeToFile() {

    }
}
