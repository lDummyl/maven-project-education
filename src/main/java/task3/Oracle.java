package task3;

public class Oracle {
    private String answer;
    private String tooLongQuestion = "Будь лаконичней...";
    private String tooShortQuestion = "Будь красноречивее...";
    private String tooManyQuestions = "Ты задаешь слишком много вопросов!";
    private String noQuestion = "Не слышу вопроса в твоих речах.";
    private String rudeness = "Иди в задницу со своими вопросами!!!";
    private String tired = "Я устал... \n Пойду отдохну.";

    public String getAnswer(String question) {
        int chance = (int) (Math.random() * 10);
        if (chance == 6) answer = rudeness;
        else if (chance > 6) answer = tired;
        else {
            if (question.length() >= 5 && question.length() <= 30) {
                if (question.toLowerCase().contains("\bчто\b")) answer = "Эти зания у тебя уже есть, загляни в свою душу";
                if (question.toLowerCase().contains("\bгде\b")) answer = "Ты попадешь туда в скором времени";
                if (question.toLowerCase().contains("\bкогда\b")) answer = "Когда наступит этот момент - ты узнаешь";
            } else if (question.length() > 30) answer = tooLongQuestion;
            else answer = tooShortQuestion;

        }

        return answer;
    }
}
