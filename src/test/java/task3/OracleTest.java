package task3;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OracleTest {

    Logger log = Logger.getLogger(Oracle.class.getName());

    // TODO: 8/29/19 тест кесков нужно несколько это как с диагностикой: что не работает? Все не работает! Чем четче кейс выделен тем тесты информативней говорят о состоянии.

    // TODO: 9/4/19  по прежнему сыпятся, так что их нужно либо починить, дибо переписать либо грохнуть.
    @Test
    public void runOracle() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        Oracle oracle = new Oracle();
        oracle.addressToOracle("what is meaning of life?");
        System.setOut(old);
        assertFalse(baos.toString().contains("what"));

        String[] questions = {"what do you want?", "not question", "where are you?", "small q",
                "very big question - not good", "what, where, when?"};
        System.setOut(ps);
        oracle.addressToOracle(questions);
        System.setOut(old);

        String report = oracle.getReportString();
        log.info(report);
        assertFalse(report.contains("what is meaning of life?"));
        //for (String question : questions) {
        //    assertTrue(report.contains(question));
        //}
    }

    @Test
    public void runOracleOneQuestion() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        Oracle oracle = new Oracle();
        oracle.addressToOracle("what is meaning of life?");
        System.setOut(old);

        log.info(baos.toString());
        assertFalse(baos.toString().contains("what"));

        String report = oracle.getReportString();
        log.info(report);

        assertTrue(report.contains("Be concise"));
    }

    // TODO: 9/5/19 надо бы этот кейс отработать и еще, пожалуй стоит сделать так чтобы страждущий добивается ответа на каждый вопрос, даже если приходится ждать или получать по башке палкой он проявлял бы настойчивость

    @Test
    public void tooManyQuestionsTestValid() {
        String[] questions = {"what is love? what is life?"};
        Oracle oracle = new Oracle();
        oracle.addressToOracle(questions);
        String reportString = oracle.getReportString();
        log.info(reportString);
        assertTrue(reportString.contains("You ask too many questions"));

    }
}
