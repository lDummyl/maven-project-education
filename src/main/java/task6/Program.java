package task6;

public class Program {

    final int size = 10;
    Double[] xValues = new Double[size];
    Double[] yValues = new Double[size];

    private Double InterpolateLagrangePolynomial(double x, Double[] xValues, Double[] yValues, int size) {
        double lagrangePol = 0.0;

        for (int i = 0; i < size; i++) {
            double basicsPol = 1.0;
            for (int j = 0; j < size; j++) {
                if (j != i) {
                    basicsPol *= (x - xValues[j]) / (xValues[i] - xValues[j]);
                }
            }
            lagrangePol += basicsPol * yValues[i];
        }

        return lagrangePol;
    }

    public void printInterpolateLagrangePolynomial(double x) {
        for (int i = 0; i < size; i++) {
            xValues[i] = i * 1.0;
            yValues[i] = TestF(i);
        }
        System.out.println(InterpolateLagrangePolynomial(x, xValues, yValues, size));

    }

    private double TestF(double x) {
        return x * x * x + 3 * x * x + 3 * x + 1; // for example
    }
}



