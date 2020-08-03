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

    // TODO: 7/29/20 наводи порядок время от времени, удаляй не использованные методы и переименовывай плохо названные.
    //  VCS сохраняет все так что если нужно сможешь достать.

    public List<String> parseQuestion(String rawLine) {
        List<String> questionsResult = new ArrayList<>();
        for (String question : questions) {
            parseAddQuestionList(rawLine, questionsResult, "(" + question + ")");
        }
        // TODO: 7/22/20 В задачу этого класса(SRP!) входит только из сырой строки получить
        //  коллекцию вопросов, но это Оракул тот кто принимает решение что вопрос может быть только один или 0 и что это значит.
        //  Путь это теперь будет его характеристикой, скжем кто-то из оракулов вполне способен совладать и с 2мя и с тремя вопросами.
        return questionsResult;
    }

    private void parseAddQuestionList(String rawLine, List<String> questionsResult, String rawPattern) {
        Pattern pattern = Pattern.compile(rawPattern);
        Matcher matcher = pattern.matcher(rawLine.toLowerCase());
        while (matcher.find()) {
            questionsResult.add(matcher.group());
        }
    }
}

