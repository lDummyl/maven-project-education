package task3;

import java.time.LocalDateTime;

public class Communication {

    private final String question;
    private final String answer;
    private final LocalDateTime timeCommunication;

    public Communication(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.timeCommunication = LocalDateTime.now();
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public LocalDateTime getTimeCommunication() {
        return timeCommunication;
    }

    @Override
    public String toString() {
        return "Communication{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", timeCommunication=" + timeCommunication +
                '}';
    }
}
