package task3;

import java.time.Duration;
import java.time.LocalDateTime;

public class Answer {
    Question question;

    public static final int maxLength = 60;
    public static final int minimumLength = 10;

    public String rudeness = "Дай-ка угадаю, кто-то украл твой сладкий рулет?";
    public String tooLongQ = "Будь лаконичнее";
    public String tooShortQ = "Будь красноречивие";
    public String noQuestionWort = "Не еслышу вопроса в речах твоих";
    public String tooMatchKeyWort = "Ты задаешь слишком много вопросов";
    public String stickHit = "(；一_一) ┻━┻༼ つ ಥ_ಥ ༽つ" + "\n" + "-Оракул бьёт вас палкой";

    public Answer(String question) {
        this.question = new Question(question);
    }

    public String rudeness() {
        return rudeness;
    }

    public String stickHit() {
        return stickHit;
    }

    public Answer() {
    }

    public void setQuestion(String question) {
        this.question = new Question(question);
    }

    public String giveAnswer() {
        if (this.question.questionLength > maxLength) {
            return tooLongQ;
        } else if (this.question.questionLength < minimumLength) {

            return tooShortQ;
        } else if (this.question.keyWort.size() < 1) {

            return noQuestionWort;
        } else if (this.question.keyWort.size() > 1) {

            return tooMatchKeyWort;
        } else {
            return RegularAnswer.getAnswer(this.question.keyWort.get(0));
        }
    }

    public String sleepAnswer(LocalDateTime stopSleepTime) {
        return "До конца сна осталось " + (Duration.between(LocalDateTime.now(), stopSleepTime).getSeconds()) + " секунд";
    }
}
