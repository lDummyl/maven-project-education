package task6;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class LagrangePolynomialTest extends TestCase {
    @Test
    public void testInterpolateLagrangePolynomial() {
        Double x= 13.5;

        Double testAnswer = x*x*x + 3*x*x + 3*x + 1;


        int size = 10;


        double[] xValues = new double[size];
        double[] yValues = new double[size];

        for (int i = 0; i < size; i++)
        {
            xValues[i] = i;
            yValues[i] = i*i*i + 3*i*i + 3*i + 1;
        }

        LagrangePolynomial lagrangePolynomial = new LagrangePolynomial(xValues, yValues);
        Double lagrange = lagrangePolynomial.getValueY(x);

        assertEquals(testAnswer, lagrange);
    }
    @Test
    public void testWrongData() {
        Double x= 13.5;

        Double testAnswer = x*x*x + 3*x*x + 3*x + 1;


        int size = 10;


        double[] xValues = new double[size];
        double[] yValues = new double[size];

        xValues[0] = 0.0;
        yValues[0] = 0.0;
        yValues[1] = 0.0;

        try {
            LagrangePolynomial lagrangePolynomial = new LagrangePolynomial(xValues, yValues);
        } catch (Exception e) {
            assertNotNull(e);
        }
    }


    @Test
    public void testListLagrangePolynomialConstr() {
        int size = 10;
        ArrayList<Double> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            xValues.add((double) i);
            yValues.add((double) (i*i*i + 3*i*i + 3*i + 1));
        }

        LagrangePolynomial lagrangePolynomial = new LagrangePolynomial(xValues, yValues);
    }

    @Test
    public void testDoubleLagrangePolynomialConstr() {
        int size = 10;
        Double[] xValues = new Double[size];
        Double[] yValues = new Double[size];
        for (int i = 0; i < size; i++)
        {
            xValues[i] = (double) i;
            yValues[i] = (double) i*i*i + 3*i*i + 3*i + 1;
        }

        LagrangePolynomial lagrangePolynomial = new LagrangePolynomial(xValues, yValues);
    }
}