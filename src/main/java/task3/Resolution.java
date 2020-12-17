package task3;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalDateTime;
import java.util.Objects;


@JsonAutoDetect
public class Resolution {
    public String question;
    public String answer;
    public LocalDateTime timeOfAsk;

    public Resolution() {
    }

    public Resolution(String question, String answer, LocalDateTime timeOfAsk) {
        this.question = question;
        this.answer = answer;
        this.timeOfAsk = timeOfAsk;
    }

    public Resolution(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setTimeOfAsk(LocalDateTime timeOfAsk) {
        this.timeOfAsk = timeOfAsk;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public LocalDateTime getTimeOfAsk() {
        return timeOfAsk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resolution that = (Resolution) o;
        return Objects.equals(question, that.question) && Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

}
