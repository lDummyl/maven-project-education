package task3;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;



@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Resolution {
    private String question;
    private String answer;
    private LocalDateTime timeOfAsk;


    public Resolution(String question, String answer, LocalDateTime timeOfAsk) {
        this.question = question;
        this.answer = answer;
        this.timeOfAsk = timeOfAsk;
    }

    public Resolution(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
