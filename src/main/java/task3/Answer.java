package task3;

import java.util.ArrayList;
import java.util.Collection;

public class Answer {
    Question question;

    public static final int maxLength = 60;
    public static final int minimumLength = 10;


    public Answer(Question question) {
        this.question = question;
    }

    public Answer(String question) {
        this.question = new Question(question);
    }

    public String rudeness() {
        return RegularAnswer.getSAnswers("rudeness");
    }

    public String stickHit() {
        return RegularAnswer.getSAnswers("stickHit");
    }

    public String giveAnswer() {
        if (this.question.questionLength > maxLength) {
            return RegularAnswer.getSAnswers("");
        } else if (this.question.questionLength < minimumLength) {
            return RegularAnswer.getSAnswers("tooShort");
        } else if (this.question.keyWort.size() < 1) {
            return RegularAnswer.getSAnswers("noKey");
        } else if (this.question.keyWort.size() > 1) {
            return RegularAnswer.getSAnswers("moreKey");
        } else {
            return RegularAnswer.getSAnswers(this.question.keyWort.get(0));
        }
    }
}
