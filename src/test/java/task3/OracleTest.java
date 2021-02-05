package task3;

import org.junit.Test;
import task4.QuestionsGenerator;



import static org.junit.Assert.*;

public class OracleTest {

    @Test
    public void ask() {
        Oracle oracle = new Oracle();
        oracle.setMaximumSleepTimeSec(1);

        QuestionsGenerator questionsGenerator = new QuestionsGenerator();

        int timesOfAsk = 10000;
        for (int i = 0; i < timesOfAsk; i++) {
            Resolution ask = oracle.ask(questionsGenerator.getQuestion());
            assertNotNull(ask);
        }
    }

    @Test
    public void askTooLongOrShort() {
        Oracle oracle = new Oracle();
        oracle.setMaximumSleepTimeSec(1);

        QuestionsGenerator questionsGenerator = new QuestionsGenerator();
        int freqToLong = 0;
        int freqOfToShort = 0;
        int timesOfAsk = 10000;

        for (int i = 0; i < timesOfAsk; i++) {
            Resolution ask = oracle.ask(questionsGenerator.getQuestion());
            assertNotNull(ask);
            if (ask.getAnswer().equals(OracleReaction.TOO_LONG.getValue())) {
                freqToLong++;
            }
            if (ask.getAnswer().equals(OracleReaction.TOO_SHORT.getValue())) {
                freqOfToShort++;
            }
        }
        assertTrue(freqToLong > 0);
        assertTrue(freqOfToShort > 0);
    }

    @Test
    public void askSleep() {
        Oracle oracle = new Oracle();
        oracle.setMaximumSleepTimeSec(1);

        QuestionsGenerator questionsGenerator = new QuestionsGenerator();
        int freqOfSleep = 0;
        int timesOfAsk = 10000;
        for (int i = 0; i < timesOfAsk; i++) {
            Resolution ask = oracle.ask(questionsGenerator.getQuestion());
            if (ask.getAnswer().contains(Oracle.leftTimeToSleepMarker)) {
                freqOfSleep++;
            }
            assertNotNull(ask);
        }
        assertTrue(freqOfSleep > 0);
    }

    @Test
    public void askMoodCheck() {
        Oracle oracle = new Oracle();
        oracle.setMaximumSleepTimeSec(1);

        QuestionsGenerator questionsGenerator = new QuestionsGenerator();
        int freqOfRudeness = 0;
        int freqOfStickHits = 0;
        int timesOfAsk = 100000;

        for (int i = 0; i < timesOfAsk; i++) {
            Resolution ask = oracle.ask(questionsGenerator.getQuestion());

            assertNotNull(ask);
            if (ask.getAnswer().contains(OracleReaction.STICK_HIT.getValue())) {
                freqOfStickHits++;
            }
            if (ask.getAnswer().contains(OracleReaction.RUDENESS.getValue())) {
                freqOfRudeness++;
            }
        }
        assertTrue(freqOfStickHits > 0);
        assertTrue(freqOfRudeness > 0);
    }

    @Test
    public void askValid() {
        Oracle oracle = new Oracle();
        oracle.setMaximumSleepTimeSec(1);

        QuestionsGenerator questionsGenerator = new QuestionsGenerator();
        int freqOfValid = 0;
        int timesOfAsk = 10000;


        for (int i = 0; i < timesOfAsk; i++) {
            Resolution ask = oracle.ask(questionsGenerator.getQuestion());
            if (Oracle.answers.containsValue(ask.getAnswer())) {
                freqOfValid++;
            }
        }
        assertTrue(freqOfValid > 0);
    }
    @Test
    public void oracleCharacterTesting(){
        Oracle oracle = new Oracle(Character.KIND);
    }

}