package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class OracleTest {

    @Test
    public void ask() {
        Oracle oracle = new Oracle();
        oracle.setMaximumSleepTimeSec(1);

        QuestionsGenerator questionsGenerator = new QuestionsGenerator();

        int timesOfAsk = 1000;
        for (int i = 0; i < timesOfAsk; i++) {
            Resolution ask = oracle.ask(questionsGenerator.getQuestion());
            assertNotNull(ask);
        }

    }
}