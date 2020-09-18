package task3.controller;

import lombok.SneakyThrows;
import task3.model.Answer;
import task3.model.Question;
import task3.service.QuestionProcessor;

import java.util.Random;
import java.util.Scanner;

public class QuestionUI {

    private final QuestionProcessor qp = new QuestionProcessor();
    private final Answer answer = new Answer();
    private final Random r = new Random();
    private final Question question = new Question();

    public void run() {
        System.out.println("Задай свой вопрос, но не короче 10 символов и не длинее 50, если вопросов больше нет," +
                "введи \"end\"");
        Scanner sc = new Scanner(System.in);
        String questionText;
        while (true) {
            questionText = sc.next();
            question.setContext(questionText);
            if (questionText.equals("end")) {
                sc.close();
                System.exit(0);
            }
            printResult(question);
        }
    }

    @SneakyThrows
    private void printResult(Question question) {
        if (r.nextInt(10) == 1) {
            System.out.println("Оракул задремал, подожди 10 секунд.");
            Thread.sleep(10000);
        }
        if (r.nextInt(10) == 2)
            answer.getAngryAnswer();
        else if (qp.isEmpty(question))
            answer.getEmptyAnswer();
        else if (qp.isContainsHardcodedWords(question))
            answer.getManyQuestionsAnswer();
        else if (qp.isLong(question))
            answer.getLongAnswer();
        else if (qp.isShort(question))
            answer.getShortAnswer();
        else
            answer.getRandomAnswer();
    }

}
