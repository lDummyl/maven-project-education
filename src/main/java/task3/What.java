package task3;

public class What implements Question {

    public static final String ANSWER = "what you need to know";
    String question = "what";

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer(String questionFromUser) {
        String answer = "";
        if (questionFromUser.contains(question)) {
            answer = ANSWER;
        }
        return answer;
    }
}
