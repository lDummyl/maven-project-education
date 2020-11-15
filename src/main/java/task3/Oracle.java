package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Oracle {
    public static final int sleepChance = 2;
    public static final int rudenessChance = 20;
    public static final int hitChance = 30;
    public static final int answerChance = 60;
    public static final int allChances = sleepChance + rudenessChance + hitChance + answerChance;

    // TODO: 13.11.2020 начни с тестов
    public void roulettAction() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String question = null;
        do {
            try {
                question = reader.readLine();

                Random random = new Random();
                int dealChance = random.nextInt(allChances);

                if (dealChance <= sleepChance) {
                    Slepping slepping = new Slepping();
                    System.out.println("Ещё пять минут");
                    System.out.println("(＿ ＿*) Z z z");
                    slepping.sleepRandom();

                } else if (dealChance <= rudenessChance) {
                    rudeness();
                } else if (dealChance <= hitChance) {
                    stickHit();
                } else {
                    giveAnswer(question);
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
        String antwort = answer.giveAnswer();
        System.out.println(antwort);
    }

    public void rudeness() {
        System.out.println("Дай-ка угадаю, кто-то украл твой сладкий рулет?");
    }

}
