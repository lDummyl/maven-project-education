package task3;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;


@JsonAutoDetect
public class Oracle {
    private int sleepChance = 10;
    private int rudenessChance = 20;
    private int hitChance = 30;
    private int answerChance = 60;
    private int allChances = sleepChance + rudenessChance + hitChance + answerChance;
    private int maximumSleepTimeSec = 59;

    LocalDateTime stopSleepTime = LocalDateTime.now();

    ObjectMapper mapper = new ObjectMapper();

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

    // TODO: 30.11.2020 Компилируется, но не пишет в файл
    public String askJson(String question) {
        String answer = ask(question);
        Resolution resolution = new Resolution(question, answer);
        try {
            mapper.writeValue(new File("/home/oblivion/Java/JavaLearn/maven-project-education/src/main/java/task3/Statistic.json"), resolution);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    // TODO: 13.11.2020 начни с тестов
    public String ask(String question) {
        int dealChance = 1 + random.nextInt(allChances);
        if (Duration.between(LocalDateTime.now(), stopSleepTime).isNegative() ||
                Duration.between(LocalDateTime.now(), stopSleepTime).isZero()) {

            if (dealChance <= sleepChance) {
                int sleepTimeSec = 1 + random.nextInt(maximumSleepTimeSec);
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


