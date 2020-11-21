package task3;

import java.util.ArrayList;
import java.util.Collection;

public class Answer {
    String answer;
    Question question;
    public static final String tooLong = "Будь лаконичнее";
    public static final String tooShort = "Будь красноречивие";
    public static final String noKey = "Не еслышу вопроса в речах твоих";
    public static final String moreKey = "Ты задаешь слишком много вопросов";
    public static final  int maxLength = 60;
    public static final  int minimumLength = 10;


    public Answer(Question question) {
        this.question = question;
    }

    public String getSpecialAnswer() {
        if (question.keyWort.size() == 0) {
            return noKey;
        } else if (question.keyWort.size() > 1) {
            return moreKey;
        } else {
            return RegularAnswer.getSAnswers(question.keyWort.get(0));
        }
    }

    public String lengthQCheck() {


        if (this.question.questionLength > maxLength) {
            return tooLong;
        } else if (this.question.questionLength < minimumLength) {
            return tooShort;
        } else {
            return null;
        }
    }

    public String giveAnswer() {
        String s = lengthQCheck();
        if (s != null) {
            return s;
        } else {
            return getSpecialAnswer();
        }
    }
}
