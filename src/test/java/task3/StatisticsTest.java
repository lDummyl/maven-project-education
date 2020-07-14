package task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class StatisticsTest {
    Statistics statistics = new Statistics();



    @Test()
    public void endSession() throws IOException {
        statistics.endSession();
        assertNotNull(new File("result.json"));//не уверен, что так правильно
    }

    @Test
    public void saveStatistic() {
        statistics.saveStatistic("test_question", "test_answer");
        assertNotNull(statistics.statisticsFromQuestionAndAnswer);
    }
}