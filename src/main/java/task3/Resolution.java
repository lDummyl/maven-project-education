package task3;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import task4.JsonReady;


@JsonAutoDetect
public class Resolution implements JsonReady {
    public String question;
    public String answer;

    public Resolution() {
    }

    public Resolution(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

}
