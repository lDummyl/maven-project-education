package task3;

import java.time.Duration;
import java.time.LocalDateTime;

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
        return RegularAnswer.getAnswer("rudeness");
    }

    public String stickHit() {
        return RegularAnswer.getAnswer("stickHit");
    }

    public Answer() {
    }

    public void setQuestion(String question) {
        this.question = new Question(question);
    }

    public String giveAnswer() {
        if (this.question.questionLength > maxLength) {
            return RegularAnswer.getAnswer("tooLong");
        } else if (this.question.questionLength < minimumLength) {
            return RegularAnswer.getAnswer("tooShort");
        } else if (this.question.keyWort.size() < 1) {
            return RegularAnswer.getAnswer("noKey");
        } else if (this.question.keyWort.size() > 1) {
            return RegularAnswer.getAnswer("moreKey");
        } else {
            return RegularAnswer.getAnswer(this.question.keyWort.get(0));
        }
    }
    public String sleepAnswer(LocalDateTime stopSleepTime){
        return "До каонца сна осталось " + Duration.between(stopSleepTime,LocalDateTime.now()).getSeconds() + " секунд";
    }
}
