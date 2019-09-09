package task4;

import task3.Question;

import java.util.ArrayList;
import java.util.List;

public class PhraseNotRandom {

    public List<String> generateQuestions(int count, Question question) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(question.name().toLowerCase());
        }
        return result;
    }
}
