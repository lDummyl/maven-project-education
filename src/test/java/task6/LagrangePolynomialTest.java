package task6;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class LagrangePolynomialTest {

    Logger log = Logger.getLogger(LagrangePolynomial.class.getName());

    @Test
    public void LagrangePolynomialTest() {
        Double[] xValues = new Double[]{4., 7.4, 12.3};
        double polynomial = LagrangePolynomial.getLagrangePolynomial(xValues, 10.);
        log.info("-> " + polynomial);
        assertEquals(polynomial, 16.77127236436743, 0.0);
    }

    @Test
    public void squareFunction3PointsGetYValid() {
        LagrangePolynomial.SquareInterpolation squareInterpolation = new LagrangePolynomial.SquareInterpolation(
                0., 0.,
                1., 1.,
                2., 4.);
        final double xToCount = 3.;
        Double xSquare = LagrangePolynomial.getYValueOfXPointByOtherTwo(squareInterpolation, xToCount);
        assertEquals(Math.pow(xToCount, 2.), xSquare, 0.1);
    }


}