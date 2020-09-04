package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test(expected = OracleExceptions.class)
    public void createdOracleOverMaxPossibility() throws OracleExceptions {
        GreatOracle greatOracle = new GreatOracle(90, 90, 1);
    }



}