package task3;

import java.util.ArrayList;
import java.util.List;

public class Conversation {

    private List<Question> questions = new ArrayList<>();

    public Conversation() {
        questions.add(new What());
        questions.add(new Where());
        questions.add(new When());
    }

    public void say(String phrase) {
        if (!phrase.equals("")) {
            output(phrase);
        }
    }

    public void action(String action) {
        if (!action.equals("")) {
            output("<" + action + ">");
        }
    }

    public void greeting() {
        output("I am, great and powerful oracle, listen to you");
    }

    public void exception() {
        output("I do't understand what you asked. Try again");
    }

    public void giveAnswerOnQuestion(String questionFromUser) {
        String answer = "";

        int countQuestions = 0;
        for (Question question : questions) {
            String answerOnQuestion = question.getAnswer(questionFromUser);
            if (!answerOnQuestion.equals("")) {
                answer = answerOnQuestion;
                countQuestions++;
            }
        }

        if (countQuestions > 1) {
            answer = "You ask too many questions";
        } else if (answer.equals("")) {
            answer = "I do't hear the question in your speeches";
        }
        output(answer);
    }

    private void output(String answer) {
        System.out.println(answer);
    }
}
