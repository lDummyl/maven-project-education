package task3;

public class When implements Question {

    String question = "when";

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer(String questionFromUser) {
        String answer = "";
        if (questionFromUser.contains(question)) {
            answer = "on time";
        }
        return answer;
    }
}
