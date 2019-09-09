package task6;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class LagrangePolynomialTest {

    Logger log = Logger.getLogger(LagrangePolynomial.class.getName());

    @Test
    public void LagrangePolynomialTest () {
        double polynomial = LagrangePolynomial.getLagrangePolynomial(10);
        log.info("-> " + polynomial);
        assertEquals(polynomial, 3112.135999993654d, 0.0);
    }
}