package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Random;


public class Oracle {
    public int sleepChance = 10;
    public int rudenessChance = 20;
    public int hitChance = 30;
    public int answerChance = 60;
    public int allChances = sleepChance + rudenessChance + hitChance + answerChance;

    Random random = new Random();

    public Oracle(int sleepChance, int rudenessChance, int hitChance, int answerChance) {
        this.sleepChance = sleepChance;
        this.rudenessChance = rudenessChance;
        this.hitChance = hitChance;
        this.answerChance = answerChance;
        this.allChances = sleepChance + rudenessChance + hitChance + answerChance;
    }

    public Oracle() {
    }

    // TODO: 13.11.2020 начни с тестов
    public void casualAction(String question) {


        int dealChance = random.nextInt(allChances);

        if (dealChance <= sleepChance) {
            sleep();
        } else if (dealChance <= rudenessChance) {
            rudeness();
        } else if (dealChance <= hitChance) {
            stickHit();
        } else {
            giveAnswer(question);
        }

    }

    public void stickHit() {
        String rudeness = "(；一_一) ┻━┻༼ つ ಥ_ಥ ༽つ" + "\n" + "-Оракул бьёт вас палкой";
        System.out.println(rudeness);
    }

    public void giveAnswer(String question) {
        Question question1 = new Question(question);
        System.out.println(new Answer(question1).giveAnswer());
    }

    public void sleep(){
        LocalDate now = LocalDate.now();
    }


    public void rudeness() {
        System.out.println("Дай-ка угадаю, кто-то украл твой сладкий рулет?");
    }

}
