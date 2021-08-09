package taskXI;

import java.io.File;
import java.time.*;
import java.util.*;


public class UserLogsProcessing implements LogsFinder, StAXParserInputFiles, StAXParserOutputFile {

    private List<UserLogs> createUserLogsList() {
        //обработка логов потоками, try-catch блок в случае прерывания (чтобы хотя бы часть объектов была создана
        //и попала в исходящий файл-отчет
        List<UserLogs> userLogsList = new ArrayList<>();
        List<File> list = findLogs("C:\\java\\logs");
        for (File file : list) {
            userLogsList.addAll(StAXParserInputFiles.super.createUserLogs(file));
        }
        return userLogsList;

    }

    private LocalDateTime getStartDateTime(UserLogs userLogs) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(userLogs.unixTime), ZoneOffset.UTC);
    }

    private LocalDateTime getEndDateTime(UserLogs userLogs) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(userLogs.unixTime).plusSeconds(userLogs.getQtySecondsUserSpend()), ZoneOffset.UTC);
    }

    private List<OutgoingFile> getListForCountingAverageTime() {
        List<UserLogs> list = createUserLogsList();
        List<OutgoingFile> outgoingFiles = new ArrayList<>();
        for (UserLogs userLogs : list) {
            LocalDateTime startDateTime = getStartDateTime(userLogs);
            LocalDateTime endDateTime = getEndDateTime(userLogs);
            LocalDate startDate = startDateTime.toLocalDate();
            LocalDate endDate = endDateTime.toLocalDate();
            LocalTime endTimeOfSession = endDateTime.toLocalTime();
            if (startDate.equals(endDate)) {
                OutgoingFile file = new OutgoingFile(userLogs.getUserID(), userLogs.getUrl(), userLogs.getQtySecondsUserSpend(), startDate);
                outgoingFiles.add(file);
            } else {
                LocalTime midnight = LocalTime.MIDNIGHT;
                long secondsAfterMidnight = Duration.between(midnight, endTimeOfSession).toSeconds();
                OutgoingFile file = new OutgoingFile(userLogs.getUserID(), userLogs.getUrl(), secondsAfterMidnight, endDate);
                long secondsBeforeMidnight = userLogs.getQtySecondsUserSpend() - secondsAfterMidnight;
                OutgoingFile file2 = new OutgoingFile(userLogs.getUserID(), userLogs.getUrl(), secondsBeforeMidnight, startDate);
                outgoingFiles.add(file);
                outgoingFiles.add(file2);
            }
        }

        return outgoingFiles;
    }

    private List<OutgoingFile> countAverageTime() {
        List<OutgoingFile> list = getListForCountingAverageTime();
        for (int i = 0; i < list.size(); i++) {
            OutgoingFile file1 = list.get(i);
            int count = 1;
            for (int j = i+1; j < list.size(); j++) {
                OutgoingFile file2 = list.get(j);
                if (file1.date.equals(file2.date) && file1.userID.equals(file2.userID) && file1.url.equals(file2.url)) {
                    count++;
                    long average = file1.average + file2.average;
                    list.remove(file2);
                    average = average / count;
                    file1.setAverage(average);
                }
            }
        }
        return list;
    }

    public Map <LocalDate, List <OutgoingFile>> getMapForWriteToFile (){
        List <OutgoingFile> list = countAverageTime();
        HashMap<LocalDate, List<OutgoingFile>> map = new HashMap<>();
        for (OutgoingFile file : list) {
            if (map.containsKey(file.date))
            {
                map.get(file.date).add(file);
            }
            else {
                List<OutgoingFile> list1 = new ArrayList<>();
                list1.add(file);
                map.put(file.date, list1);
            }
        }
        return map;
    }

    @Override
    public void writeToFile(Map<LocalDate, List<OutgoingFile>> map) {
        StAXParserOutputFile.super.writeToFile(map);
    }
}
