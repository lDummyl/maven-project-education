package task3;


import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect
public class Resolution {
    String question;
    String answer;

    public Resolution(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
