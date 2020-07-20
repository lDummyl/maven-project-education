package task3;

import java.util.HashSet;
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
}

