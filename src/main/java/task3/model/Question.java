package task3.model;

import lombok.Data;

@Data
public class Question {

    public static final Integer MIN_LENGTH = 10;
    public static final Integer MAX_LENGTH = 50;
    private final String[] forbiddenWords = {"что", "кто", "где", "почему", "когда", "зачем"};
    private String context;

    public void setContext(String context) {
        this.context = context;

    }
}
