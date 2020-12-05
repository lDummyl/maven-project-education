package task4;

import org.junit.Test;

import static org.junit.Assert.*;

public class OracleAskGeneratorTest {

    @Test
    public void askAndSerialize() {
        OracleAskGenerator oracleAskGenerator = new OracleAskGenerator();
        oracleAskGenerator.askAndSerialize(1000);
    }
}