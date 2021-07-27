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

    public Map<LocalDate, List<OutgoingFile>> getFileForOut(List<UserLogs> list) {
        HashMap<LocalDate, List<OutgoingFile>> map = new HashMap<>();
        List <OutgoingFile> outgoingFiles = new ArrayList<>();
        for (UserLogs userLogs : list) {
            LocalDateTime startDateTime = getStartDateTime(userLogs);
            LocalDateTime endDateTime = getEndDateTime(userLogs);
            LocalDate startDate = startDateTime.toLocalDate();
            LocalDate endDate = endDateTime.toLocalDate();
            LocalTime endTimeOfSession = endDateTime.toLocalTime();
            if (startDate.equals(endDate)) {
                outgoingFiles.add(new OutgoingFile(userLogs.getUserID(), userLogs.getUrl(), userLogs.getQtySecondsUserSpend()));
                map.put(startDate,outgoingFiles);
            } else
            {
                LocalTime midnight = LocalTime.MIDNIGHT;
                long secondsAfterMidnight = Duration.between(midnight, endTimeOfSession).toSeconds();
                outgoingFiles.add(new OutgoingFile(userLogs.getUserID(), userLogs.getUrl(), secondsAfterMidnight));
                map.put(endDate, outgoingFiles);
                long secondsBeforeMidnight = userLogs.getQtySecondsUserSpend() - secondsAfterMidnight;
                outgoingFiles.add(new OutgoingFile(userLogs.getUserID(), userLogs.getUrl(), secondsBeforeMidnight));
                map.put(startDate, outgoingFiles);
            }
        }
        return map;
    }


    @Override
    public void writeToFile() {

    }
}
