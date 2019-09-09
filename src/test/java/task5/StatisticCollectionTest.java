package task5;

import org.junit.Test;
import task3.Oracle;
import task3.Question;
import task4.PhraseNotRandom;
import task4.Seeker;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class StatisticCollectionTest {

    Logger log = Logger.getLogger(StatisticCollection.class.getName());

    // TODO: 9/3/19 починил тебе тест, всегда старайся внимаетельно с тем что пишут в консоль.

    @Test
    public void statisticCollectionTest() {
        //Oracle oracle = new Oracle(3, Duration.ofMillis(3L));
        //Seeker seeker = new Seeker();

        //seeker.generateQuestions(10);
        //oracle.addressToOracle(seeker.getQuestions());

        StatisticCollection statistic = new StatisticCollection("conversation.json");
        log.info("count: " + statistic.getCountAction(Oracle.SHORT_QUESTION));
        log.info("max time sleep: " + statistic.getMaxSleepTimeOracle().getSeconds());
        log.info(statistic.getPopularQuestions(10).toString());
    }

    @Test
    public void popularQuestionsTest () {
        PhraseNotRandom phraseNotRandom = new PhraseNotRandom();
        Oracle oracle = new Oracle(3, Duration.ofMillis(3L));
        //Seeker seeker = new Seeker();

        List<String> questions = phraseNotRandom.generateQuestions(10, Question.WHY);
        questions.stream().forEach(i -> assertEquals(i, Question.WHY.name().toLowerCase()));

        oracle.addressToOracle(questions);

        StatisticCollection statistic = new StatisticCollection(oracle);
        Map<String, Long> popularQuestions = statistic.getPopularQuestions(1);
        for (Map.Entry<String, Long> entry : popularQuestions.entrySet()) {
            assertEquals(entry.getKey(), Question.WHY.name().toLowerCase());
            assertEquals(entry.getValue(), new Long(questions.size()));
        }
    }

    @Test
    public void getCountActionTest () {
        PhraseNotRandom phraseNotRandom = new PhraseNotRandom();
        Oracle oracle = new Oracle(3, Duration.ofMillis(3L));

        int qty = 10;
        oracle.addressToOracle(phraseNotRandom.generateQuestions(qty, Question.WHEN));

        StatisticCollection statistic = new StatisticCollection(oracle);
        long countAction = statistic.getCountAction(Oracle.SHORT_QUESTION);
        assertEquals(countAction, qty);
    }
}
