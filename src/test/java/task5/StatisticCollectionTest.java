package task5;

import org.junit.Test;
import task3.Oracle;
import task4.Seeker;

import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StatisticCollectionTest {

    Logger log = Logger.getLogger(StatisticCollection.class.getName());

    // TODO: 9/3/19 починил тебе тест, всегда старайся внимаетельно с тем что пишут в консоль.

    @Test
    public void statisticCollectionTest() {
        //Oracle oracle = new Oracle();
        //Seeker seeker = new Seeker();

        //seeker.generateQuestions(10);
        //oracle.addressToOracle(seeker.getQuestions());

        StatisticCollection statistic = new StatisticCollection("conversation.json");
        log.info("count: " + statistic.getCountAction(Oracle.SHORT_QUESTION));
        log.info("max time sleep: " + statistic.getMaxSleepTimeOracle());
        log.info(statistic.getPopularQuestions().toString());
    }
}