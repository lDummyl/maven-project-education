package task3;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import task4.JsonReady;


@JsonAutoDetect
@JsonAppend
public class Resolution implements JsonReady {
    public final String question;
    public final String answer;

    public Resolution(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
