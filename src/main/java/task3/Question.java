package task3;

import java.util.ArrayList;

public class Question {
    String questionText;
    SpecialQuest specialQuest;
    int questionLength;

    public Question(String questionText) {
        this.questionText = questionText;
        this.specialQuest = new SpecialQuest(questionText);
        this.questionLength = questionText.length();
    }

}
