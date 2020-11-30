package task3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;


public class Oracle {
    private int sleepChance = 10;
    private int rudenessChance = 20;
    private int hitChance = 30;
    private int answerChance = 60;
    private int allChances = sleepChance + rudenessChance + hitChance + answerChance;
    private int maximumSleepTimeSec = 59;

    LocalDateTime stopSleepTime = LocalDateTime.now();

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

    public void setMaximumSleepTimeSec(int maximumSleepTimeSec) {
        this.maximumSleepTimeSec = maximumSleepTimeSec;
    }


    // TODO: 13.11.2020 начни с тестов
    public String ask(String question) {
        int dealChance = 1 + random.nextInt(allChances);
        if (Duration.between(LocalDateTime.now(), stopSleepTime).isNegative() ||
                Duration.between(LocalDateTime.now(), stopSleepTime).isZero()) {

            if (dealChance <= sleepChance) {
                int sleepTimeSec =1 + random.nextInt(maximumSleepTimeSec);
                this.stopSleepTime = LocalDateTime.now().plusSeconds(sleepTimeSec);
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


