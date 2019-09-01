package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Seeker {

    private PhraseGenerator phraseGenerator = new PhraseGenerator(2);
    private List<String> questions = new ArrayList<>();
    private Random random = new Random();

    public void generateQuestions(int countQuestions) {
        if (countQuestions <= 0) {
            countQuestions = 1;
        }
        for (int i = 0; i < countQuestions; i++) {
            questions.add(getQuestion());
        }
    }

    public String getQuestion() {
        return phraseGenerator.generatePhrase();
    }

    public List<String> getQuestions() {
        return questions;
    }
}
