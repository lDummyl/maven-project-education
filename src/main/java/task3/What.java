package task3;

public class What implements Question {

    String question = "what";

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer(String questionFromUser) {
        String answer = "";
        if (questionFromUser.contains(question)) {
            answer = "what you need to know";
        }
        return answer;
    }
}
