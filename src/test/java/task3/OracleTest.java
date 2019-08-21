package task3;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class OracleTest {

    @Test
    public void runOracle() {
        Oracle oracle = new Oracle();
        oracle.addressToOracle();
    }

    // TODO: 8/21/19 TDD наше всё, болше тестов, этот покрывает 32% твоего кода и падает, не хорошо.
    @Test
    public void runOracleAuto() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        Oracle oracle = new Oracle();
        oracle.addressToOracle("what is meaning of life?");
        System.setOut(old);
        assertTrue(baos.toString().contains(What.ANSWER));
    }
}
