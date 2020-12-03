package task3;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static task3.Answer.maxLength;


@JsonAutoDetect
public class Oracle {
    private int sleepChance = 10;
    private int rudenessChance = 20;
    private int hitChance = 30;
    private int answerChance = 60;
    private int allChances = sleepChance + rudenessChance + hitChance + answerChance;
    private int maximumSleepTimeSec = 59;

    public static final int maxLength = 60;
    public static final int minLength = 10;

    LocalDateTime stopSleepTime = LocalDateTime.now();

    ObjectMapper mapper = new ObjectMapper();

    Random random = new Random();
    Answer answer = new Answer();

    List<Resolution> resolutions = new ArrayList();


    File file;
    JsonGenerator g;

    public Oracle(int sleepChance, int rudenessChance, int hitChance, int answerChance) {
        this.sleepChance = sleepChance;
        this.rudenessChance = rudenessChance;
        this.hitChance = hitChance;
        this.answerChance = answerChance;
        this.allChances = sleepChance + rudenessChance + hitChance + answerChance;
    }

    public Oracle() {
        this.file = new File("/home/oblivion/Java/JavaLearn/maven-project-education/src/main/java/task3/Statistic.json");
    }

    public void setMaximumSleepTimeSec(int maximumSleepTimeSec) {
        this.maximumSleepTimeSec = maximumSleepTimeSec;
    }

    // TODO: 30.11.2020 Компилируется, но не пишет в файл

    /*public String askJson(String question) {
        String answer = ask(question);
        Resolution resolution = new Resolution(question, answer);
        resolutions.add(resolution);
        try {
            mapper.writeValue(file, resolutions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }*/

    // TODO: 13.11.2020 начни с тестов
    // FIXME: 30.11.2020 Всё время уходит в сон
/*    public Resolution askJson(String question) {
        String answer = ask(question);
        Resolution resolution = new Resolution(question, answer);
        resolutions.add(resolution);
        try {
            mapper.writeValue(file, resolutions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }*/
    public Resolution ask(String question) {
        try {
            lengthCheck(question);
            questionPresenceCheck(question);
            moodCheck();
            fatigueCheck();
            return validAnswer(question);
        } catch (OracleException e) {
            OracleReaction reaction = e.reaction;
            return new Resolution(question, reaction.name());
        }


      /*  int dealChance = 0;
        try {
            dealChance = 1 + random.nextInt(allChances);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        }*/
    }

    private Resolution validAnswer(String question) {
        throw new NotImplementedException();
    }

    private void fatigueCheck() {
        throw new NotImplementedException();
    }

    private void moodCheck() {
        throw new NotImplementedException();
    }

    private void questionPresenceCheck(String question) {
        throw new NotImplementedException();
    }

    public static void main(String[] args) {
        Oracle oracle = new Oracle();
        //oracle.lengthCheck("sdasd", "fdsafd");
    }

    private void lengthCheck(String question) throws OracleException {
        if (question.length() < minLength) {
            throw new OracleException(OracleReaction.FUCK_OFF);
        } else if (question.length() > maxLength) {
            throw new OracleException(OracleReaction.FUCK_OFF);
        }
    }

}


