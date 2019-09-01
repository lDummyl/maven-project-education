package task4;

import org.junit.Test;
import task3.Oracle;

import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SeekerTest {

    Logger log = Logger.getLogger(Seeker.class.getName());

    @Test
    public void seekerTest() {
        Seeker seeker = new Seeker();
        Oracle oracle = new Oracle();

        String question = seeker.getQuestion();
        oracle.addressToOracle(question);

        seeker.generateQuestions(100);
        oracle.addressToOracle(seeker.getQuestions());

        String report = oracle.getReportString();
        seeker.getQuestions().stream().forEach(i -> assertTrue(report.contains(i)));
    }
}