package task6;

public class LagrangePolynomial {

    public static double getLagrangePolynomial(int size) {
        return calculateLagrangePolynomial(size, 13.6d);
    }

    public static double getLagrangePolynomial(int size, double x) {
        return calculateLagrangePolynomial(size, x);
    }

    private static double calculateLagrangePolynomial(int size, double x) {
        double[] xValues = new double[size];
        double[] yValues = new double[size];

        for (int i = 0; i < size; i++) {
            xValues[i] = i;
            yValues[i] = testF(i);
        }

        return interpolateLagrangePolynomial(x, xValues, yValues, size);
    }

    private static double interpolateLagrangePolynomial (double x, double[] xValues, double[] yValues, int size) {
        double lagrangePol = 0;

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

    private static double testF(double x) {
        return  x*x*x + 3*x*x + 3*x + 1; // for example
    }
}
