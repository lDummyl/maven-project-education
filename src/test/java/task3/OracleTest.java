package task3;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class OracleTest {

    @Test
    public void ask() {
        Oracle oracle = new Oracle(0, 0, 0, 1);
        String testWithKey = oracle.ask("что + This is text for testing");
        assertNotNull(testWithKey);
        String testAnswer = RegularAnswer.getAnswer("Что");
        assertEquals(testAnswer, testWithKey);
    }

    @Test
    public void askMore() {
        Oracle oracle = new Oracle(0, 0, 0, 1);
        HashMap<String, String> answers = RegularAnswer.getAnswers();

        ArrayList<String> keyWortFromMap = new ArrayList<>(answers.keySet());

        for (String key : keyWortFromMap) {
            String current = key + "This is text for testing";
            assertEquals(answers.get(key), oracle.ask(current));
        }
    }

    @Test
    public void askRudeness() {
        Oracle oracle = new Oracle(0, 1, 0, 0);
        String testString = oracle.ask("This is text for testing");
        assertNotNull(testString);
        assertEquals(oracle.answer.rudeness, testString);
    }
    @Test
    public void askStickHit() {
        Oracle oracle = new Oracle(0, 0, 1, 0);
        String testString = oracle.ask("This is text for testing");
        assertNotNull(testString);
        assertEquals(oracle.answer.stickHit, testString);
    }

    // TODO: 30.11.2020 Придумать способ проверки корректностиотображения времени
    @Test
    public void sleepTest() {
        Oracle oracle = new Oracle(1, 0, 0, 0);
        oracle.setMaximumSleepTimeSec(15);
        String testString1 = oracle.ask("This is text for testing");
        String testString2 = oracle.ask("This is text for testing");
        assertNotNull(testString1);
        assertNotNull(testString2);
        assertNotEquals(testString1, testString2);
    }
    @Test
    public void askTest(){
        Oracle oracle = new Oracle(1, 2,3 , 10);
        oracle.setMaximumSleepTimeSec(1);
        String testString1 = oracle.ask("This is text for testing");
        int testTime= 100;
        for (int i = 0; i < testTime; i++) {
            String ask = oracle.ask(testString1);
            assertNotNull(ask);
        }
    }
    @Test
    public void askTestJson(){
        Oracle oracle = new Oracle(1, 2,3 , 10);
        oracle.setMaximumSleepTimeSec(1);
        String testString1 = oracle.ask("This is text for testing");
        int testTime= 100;
        for (int i = 0; i < testTime; i++) {
            String ask = null;
            ask = oracle.askJson(testString1);
            assertNotNull(ask);
        }
    }
}