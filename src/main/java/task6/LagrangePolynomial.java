package task6;

import java.util.Arrays;

public class LagrangePolynomial {

    public static Double getLagrangePolynomial(Double[] xValues, Double x) {
        Double[] yValues = new Double[xValues.length];

        for (int i = 0; i < xValues.length; i++) {
            yValues[i] = getY(xValues[i]);
        }

        return calculateLagrangePolynomial(xValues, yValues, x);
    }

    public static Double getLagrangePolynomial(Double[] xValues, Double[] yValues, Double x) {
        return calculateLagrangePolynomial(xValues, yValues, x);
    }

    private static Double calculateLagrangePolynomial(Double[] xValues, Double[] yValues, Double x) {
        if (checkArrays(xValues, yValues)) {
            return interpolateLagrangePolynomial(x, xValues, yValues);
        }
        return 0.;
    }

    private static Boolean checkArrays(Double[] xValues, Double[] yValues) {
        return (xValues.length == yValues.length
                && checkCorrectArrayValues(xValues)
                && checkCorrectArrayValues(yValues));
    }

    private static Boolean checkCorrectArrayValues(Double[] array) {
        long uncorrectedValues = Arrays.stream(array).filter(i -> i <= 0).count();
        return uncorrectedValues == 0;
    }

    private static Double interpolateLagrangePolynomial(Double x, Double[] xValues, Double[] yValues) {
        Double lagrangePol = 0.;
        int size = xValues.length;

        for (int i = 0; i < size; i++) {
            double basicsPol = 1;
            for (int j = 0; j < size; j++) {
                if (j != i) {
                    basicsPol *= (x - xValues[j])/(xValues[i] - xValues[j]);
                }
            }
            lagrangePol += basicsPol * yValues[i];
        }

        return lagrangePol;
    }

    private static Double getY(Double x) {
        return  x*x*x + 3*x*x + 3*x + 1;
    }
}
