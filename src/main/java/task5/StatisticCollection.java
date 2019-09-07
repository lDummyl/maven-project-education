package task5;

import lombok.NonNull;
import lombok.SneakyThrows;
import task3.Communication;
import task3.Converter;
import task3.Oracle;

import java.time.Duration;
import java.util.*;
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
        return historyConversation.stream().filter(i -> i.getAction().equals(action)).count();
    }

    public Long getMaxSleepTimeOracle() {
        long maxSleepTime = 0L;
        for (Communication communication : historyConversation) {
            long sleepTime = communication.getDurationSleepTime().getSeconds();
            if (communication.getAction().equals(Oracle.SLEEP) && sleepTime > maxSleepTime) {
                maxSleepTime = sleepTime;
            }
        }
        return maxSleepTime;
    }

    public Map<String, Long> getPopularQuestions(int countGet) {
        Map<String, Long> popularQuestions = historyConversation.stream()
                .collect(Collectors.groupingBy(Communication::getQuestion, Collectors.counting()));
        if (popularQuestions.values().stream().mapToDouble(Long::doubleValue).max().orElse(0) > 1) {
            popularQuestions.entrySet().removeIf(i -> i.getValue() == 1);
        }
        if (popularQuestions.size() < countGet) {
            countGet = popularQuestions.size();
        }
        return popularQuestions.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(countGet)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
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
