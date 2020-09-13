package task3.model;

import lombok.Data;

@Data
public class Question {

    private final Integer minLength = 10;
    private final Integer maxLength = 50;
    private final String[] forbiddenWords = {"who", "where", "why", "when"};
    private String context;

    public void setContext(String context) {
        this.context = context;

    }
}
