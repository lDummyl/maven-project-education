package task3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class QuestionExtractor {
    final Set<String> questions;

    public QuestionExtractor(Set<String> questions) {
        this.questions = questions;
    }

    public Set<String> parse(String rawLine) {
        Set<String> questionsResult = new HashSet<>();
        for (String question : questions) {
            parseDDD(rawLine, questionsResult, "(" + question + ")");
        }

        return questionsResult;
    }

    public String parse123(String rawLine) {
        List<String> questionsResult = new ArrayList<>();
        for (String question : questions) {
            parseDDD(rawLine, questionsResult, "(" + question + ")");
        }
        // TODO: 7/22/20 В задачу этого класса(SRP!) входит только из сырой строки получить
        //  коллекцию вопросов, но это Оракул тот кто принимает решение что вопрос может быть только один или 0 и что это значит.
        //  Путь это теперь будет его характеристикой, скжем кто-то из оракулов вполне способен совладать и с 2мя и с тремя вопросами.

        if (questionsResult.size() == 0){
            return "-10";
        }else if (questionsResult.size() > 1){
            return "-20";
        }else {
            String approve = questionsResult.get(0);
            return approve;
        }
    }


    public Set<String> parseSinglePattern(String rawLine) {
        Set<String> questionsResult = new HashSet<>();
        String rawPattern = questions.stream().collect(Collectors.joining("|", "(", ")"));
        parseDDD(rawLine, questionsResult, rawPattern);
        return questionsResult;
    }

    private void parseDDD(String rawLine, Set<String> questionsResult, String rawPattern) {
        Pattern pattern = Pattern.compile(rawPattern);
        Matcher matcher = pattern.matcher(rawLine.toLowerCase());
        while (matcher.find()) {
            questionsResult.add(matcher.group());
        }
    }
    private void parseDDD(String rawLine, List<String> questionsResult, String rawPattern) {
        Pattern pattern = Pattern.compile(rawPattern);
        Matcher matcher = pattern.matcher(rawLine.toLowerCase());
        while (matcher.find()) {
            questionsResult.add(matcher.group());
        }
    }
}

