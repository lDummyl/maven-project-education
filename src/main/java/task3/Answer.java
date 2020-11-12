package task3;

import java.util.Collection;

public class Answer {
    String answer;


    public String getSpecialAnswer(Collection<String> questions) {
        if (questions.size() == 0){
            return "Не еслышу вопроса в речах твоих";
        }
        else if (questions.size() > 1){
            return "Ты задаешь слишком много вопросов";
        }
        else {
            return null;
        }
    }

    public String lengthQCheck(String quest) {
        int maxLength = 30;
        int minimumLength = 10;

        if (quest.length() > maxLength) {
            return "Будь лаконичнее";
        }
        else if (quest.length() < minimumLength) {
            return "Будь красноречивие";
        }
        else {
            return null;
        }
    }

    public String giveAnswer(String quest){


        return null;
    }
}
