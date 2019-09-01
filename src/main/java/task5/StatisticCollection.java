package task5;

import lombok.NonNull;
import lombok.SneakyThrows;
import task3.Communication;
import task3.Converter;
import task3.Oracle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticCollection {

    private Oracle oracle;
    private List<Communication> historyConversation = new ArrayList<>();
    private Duration duration;

    public StatisticCollection(String pathFile) {
        getHistoryConversationFromFile(pathFile);
    }

    @NonNull
    public StatisticCollection(Oracle oracle) {
        setOracle(oracle);
    }

    public Long getCountAction(String action) {
        return historyConversation.stream().filter(i -> i.getAction().equals(action)).count(); // тут сыпется, пока не могу разобраться в в чем ошибка
    }

    public Long getMaxSleepTimeOracle() {
        long maxSleepTime = 0L;
        LocalDateTime previousDate = null;
        for (Communication communication : historyConversation) { // тут тоже сыпется...
            if (communication.getAction().equals(Oracle.SLEEP) && previousDate != null) {
                duration = Duration.between(communication.getTimeCommunication(), previousDate);
                if (duration.getSeconds() > maxSleepTime) {
                    maxSleepTime = duration.getSeconds();
                }
            }
            previousDate = communication.getTimeCommunication();
        }
        return maxSleepTime;
    }

    public Map<String, Long> getPopularQuestions() {
        Map<String, Long> popularQuestions = historyConversation.stream()
                .collect(Collectors.groupingBy(Communication::getQuestion, Collectors.counting())); // и тут сыпется... пытаюсь разобраться
        return popularQuestions;
    }

    private void getHistoryConversationFromOracle() {
        historyConversation = oracle.getHistoryConversation();
    }

    @SneakyThrows
    private void getHistoryConversationFromFile(String pathFile) {
        historyConversation = new Converter(pathFile).fromJSON();
    }

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
        getHistoryConversationFromOracle();
    }
}
