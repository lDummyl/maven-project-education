package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Oracle {

    private final int shortQuestion = 10;
    private final int longQuestion = 20;
    private Random random = new Random();
    private List<Question> questions = new ArrayList<>();

    public Oracle() {
        questions.add(new What());
        questions.add(new Where());
        questions.add(new When());
    }

    public void addressToOracle() {
        System.out.println("I am, great and powerful oracle, listen to you");

        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        String question;
        boolean exit = false;
        while (!exit) {
            try {
                question = bufferedReader.readLine();
            } catch (IOException exc) {
                question = "";
                System.out.println("I do't understand what you asked. Try again");
            }

            question = question.toLowerCase().trim();
            if (question.equals("e")) {
                exit = true;
            } else if (!question.equals("")) {
                parsingQuestion(question);
            }
        }
    }

    private void parsingQuestion(String questionFromUser) {
        boolean wantToAnswer = makeDecision();
        if (wantToAnswer) {
            if (questionFromUser.length() >= longQuestion) {
                System.out.println("Be concise");
            } else if (questionFromUser.length() <= shortQuestion) {
                System.out.println("Be more eloquent");
            } else {
                System.out.println(getAnswer(questionFromUser));
            }
        }
    }

    private Boolean makeDecision() {
        // еще не реализовал
        // оракул может рандомно нахамить или стукнуть палкой, может устать и сделать перерыв на 10 сек до минуты
        int variant = random.nextInt(3);
        return true;
    }

    private String getAnswer(String questionFromUser) {
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
        return answer;
    }
}
