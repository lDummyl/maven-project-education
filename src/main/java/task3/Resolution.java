package task3;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import task4.JsonReady;


@JsonAutoDetect
@JsonAppend
public class Resolution implements JsonReady {
    public String question;
    public String answer;

    public Resolution() {
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

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

}
