package task3;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonAppend;


@JsonAutoDetect
@JsonAppend
public class Resolution {
    public String question;
    public String answer;

    public Resolution(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
