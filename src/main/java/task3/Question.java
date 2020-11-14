package task3;

import java.util.ArrayList;
import java.util.Collection;

public class Question {
    String questionText;
    int questionLength;
    public static final String[] specialQuests = {"Кто", "Что", "Где", "Когда", "Почему", "Зачем", "Куда", "Сколько", "Как"};
    ArrayList<String> keyWort;

    public Question(String questionText) {
        this.questionText = questionText;
        this.questionLength = questionText.length();
        this.keyWort = specialQuestCheck(questionText);
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getQuestionLength() {
        return questionLength;
    }

    public ArrayList<String> getKeyWort() {
        return keyWort;
    }

    public ArrayList<String> specialQuestCheck(String quest) {
        ArrayList<String> questions = new ArrayList<>();

       // System.out.println(quest.toLowerCase());
        for (String s : specialQuests) {
            if (quest.contains(s) || quest.contains(s.toLowerCase())) {
                questions.add(s);
            }
        }
        return questions;
    }
}
