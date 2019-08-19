package task3;

public class Where implements Question {

    String question = "where";

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer(String questionFromUser) {
        String answer = "";
        if (questionFromUser.contains(question)) {
            answer = "somewhere";
        }
        return answer;
    }
}
