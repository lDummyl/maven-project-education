package task6;

import junit.framework.TestCase;
import org.junit.Test;

public class LagrangePolynomialTest extends TestCase {
    @Test
    public void testInterpolateLagrangePolynomial() {
        Double x= 13.4;

        Double testAnswer = x*x*x + 3*x*x + 3*x + 1;
        System.out.println(testAnswer);

        int size = 10;


        double[] xValues = new double[size];
        double[] yValues = new double[size];

        for (int i = 0; i < size; i++)
        {
            xValues[i] = i;
            yValues[i] = i*i*i + 3*i*i + 3*i + 1;
        }


        double lagrange = LagrangePolynomial.InterpolateLagrangePolynomial(x, xValues, yValues, size);

        assertEquals(testAnswer, lagrange);
    }
}