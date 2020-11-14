package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Oracle {

    // TODO: 13.11.2020 начни с тестов
    public void roulettAction(String question) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                String que = reader.readLine();

                Random random = new Random();
                int dealChance = random.nextInt(100);

                if (dealChance <= 10) {

                    // TODO: 11/13/2020 (Для себя) Попробовать через local Date

                } else if (dealChance <= 20) {
                    rudeness();
                } else if (dealChance <= 30) {
                    stickHit();
                } else {
                    giveAnswer(que);
                }

            } catch (IOException e) {
                System.out.println("Некорректен вопрос");
            }
        }
        while (!question.equals("Я получил все ответы"));
    }


    public void stickHit() {
        System.out.println("(；一_一) ┻━┻༼ つ ಥ_ಥ ༽つ");
        System.out.println("-Оракул бьёт вас палкой");
    }

    public void sleeping(String question) {

    }

    public void giveAnswer(String question) {
        Question question1 = new Question(question);
        Answer answer = new Answer(question1);
        System.out.println(answer.giveAnswer());
    }

    public void rudeness() {
        System.out.println("Дай-ка угадаю, кто-то украл твой сладкий рулет?");
    }

}
