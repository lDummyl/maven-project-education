package taskXI;

import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserLogsProcessing implements LogsFinder, StAXParserInputFiles {

    public void createUserLogs() {
        //обработка логов потоками, try-catch блок в случае прерывания (чтобы хотя бы часть объектов была создана
        //и попала в исходящий файл-отчет
        List<File> list = findLogs("C:\\java\\logs");
        for (File file : list) {
            System.out.println(StAXParserInputFiles.super.createUserLogs(file));
        }

    }

    List<UserLogs> getLogsList() {
        List<UserLogs> list = new ArrayList<>();
        //list.add(createUserLogs());
        return list;
    }

    Instant startDate;
    Instant endDate;

    public Instant getStartDate(UserLogs userLogs) {
        return Instant.ofEpochSecond(userLogs.unixTime);
    }

    public Instant getEndDate(UserLogs userLogs) {
        return getStartDate(userLogs).plusSeconds(userLogs.getQtySecondsUserSpend());
    }

    public Map<Instant, OutgoingFile> getFileForOut(List<UserLogs> list) {
        //пока не разобралась что именно использовать для работы с временем
        return null;
    }

    @Override
    public void writeToFile() {

    }
}
