package task5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import task3.Conversation;
import task3.Oracle;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Statistic {
    Oracle oracle = new Oracle();

    private File getFile() {
        String path = "C:\\Users\\Krugl\\IdeaProjects\\maven-project-education\\conversation.json";
        return new File(path);
    }

    private List<Conversation> getListFromJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(getFile(), new TypeReference<List<Conversation>>() {
        });
    }

    public int qtyInvalidAnswers(Oracle.Action action) throws IOException {
        List<Conversation> list = getListFromJSON();
        int invalidAnswer = 0;
        for (Conversation conversation : list) {
            String rudeAnswer = oracle.invalidAnswers.get(action);
            if (conversation.getAnswer().equals(rudeAnswer)) {
                invalidAnswer++;
            }
        }
        return invalidAnswer;
    }

    public int qtyTimeOracleSleep() throws IOException {
        List<Conversation> list = getListFromJSON();
        int count = 0;
        for (Conversation conversation : list) {
            String answer = conversation.getAnswer();
            String s = "Оракул отдыхал";
            if (answer.contains(s)) {
                String q = answer.replace(s,"").trim();
                int x = Integer.parseInt(q);
                count = count+x;
            }
        }
        return count;
    }

    public Map <String,Integer> getQuestionStatistic() throws IOException {
        List<Conversation> list = getListFromJSON();
        List<String> questions = new ArrayList<>();
        for (Conversation conversation : list) {
            questions.add(conversation.getQuestion());
        }
        Map<String,Integer> questionsStatistic = new HashMap<>();
        for (String question : questions) {
            if (questionsStatistic.containsKey(question)) {
                questionsStatistic.put(question, questionsStatistic.get(question) + 1);
            } else {
                questionsStatistic.put(question, 1);
            }
        }
        return questionsStatistic;
    }

    public Map<String,Integer> getTopFrequencyQuestions(Map <String,Integer> questionStatistic, int x) throws IOException {
        return questionStatistic.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .limit(x)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x1, x2) -> x1, LinkedHashMap::new));
    }

    public Statistic() throws IOException {
    }
}
