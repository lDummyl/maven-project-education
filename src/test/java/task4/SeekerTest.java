package task4;

import org.junit.Test;
import task3.Oracle;

import java.time.Duration;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SeekerTest {

    Logger log = Logger.getLogger(Seeker.class.getName());

    @Test
    public void seekerTest() {
        Seeker seeker = new Seeker();
        Oracle oracle = new Oracle(Duration.ofSeconds(3L)); // TODO: 9/1/19  чтобы не ждать 100 лет пока тест пройдет, а так быть не должно в принципе, при инициализации я бы передавал в констуктор максимальное время ожидания оракула(именно время(Duration) никаких интов) и тогда в тестовом режиме все бы проходило за разумный период

        String question = seeker.getQuestion();
        oracle.addressToOracle(question);

        seeker.generateQuestions(100);
        oracle.addressToOracle(seeker.getQuestions());

        String report = oracle.getReportString();
        seeker.getQuestions().stream().forEach(i -> assertTrue(report.contains(i))); // TODO: 9/1/19 слишком вольная проверка на первый взгляд
    }
}