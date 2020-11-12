package task3;

import java.util.ArrayList;

public class Question {
    String questionText;
    SpecialQuest specialQuest;
    int questionLength;
    int specialQuestLen;

    public Question(String questionText) {
        this.questionText = questionText;
        this.specialQuest = new SpecialQuest(questionText);
        this.questionLength = questionText.length();
        this.specialQuestLen = specialQuest.getSpecialQuest().size();
    }

}
