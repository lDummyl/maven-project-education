package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;


public class Oracle {
    public int sleepChance = 10;
    public int rudenessChance = 20;
    public int hitChance = 30;
    public int answerChance = 60;
    public int allChances = sleepChance + rudenessChance + hitChance + answerChance;
    public static final int maximumSleepTimeSec = 60;

    LocalDateTime stopSleepTime;
    int sleepTimeSec;

    Random random = new Random();
    Answer answer = new Answer();

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
    public String ask(String question) {
        int dealChance = random.nextInt(allChances);
        if (Duration.between(LocalDateTime.now(), stopSleepTime).isNegative() ||
                Duration.between(LocalDateTime.now(), stopSleepTime).isZero()) {

            if (dealChance <= sleepChance) {
                this.sleepTimeSec = random.nextInt(maximumSleepTimeSec);
                this.stopSleepTime = LocalDateTime.now().plusSeconds(sleepTimeSec);
                this.sleepTimeSec = 0;
                return "Оракул заснул";
            } else if (dealChance <= rudenessChance) {
                return answer.rudeness();
            } else if (dealChance <= hitChance) {
                return answer.stickHit();
            } else {
                answer.setQuestion(question);
                return answer.giveAnswer();
            }
        } else {
            return answer.sleepAnswer(stopSleepTime);
        }
    }
}


