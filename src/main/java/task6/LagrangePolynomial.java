package task6;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Stream;

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

    public static Double getYValueOfXPointByOtherTwo(SquareInterpolation.Point a, SquareInterpolation.Point b, SquareInterpolation.Point c, Double x) {
        Double[] xValues = Stream.of(a, b, c).map(SquareInterpolation.Point::getX).toArray(Double[]::new);
        Double[] yValues = Stream.of(a, b, c).map(SquareInterpolation.Point::getY).toArray(Double[]::new);
        return calculateLagrangePolynomial(xValues, yValues, x);
    }

    public static Double getYValueOfXPointByOtherTwo(SquareInterpolation squareInterpolation, Double x) {
        return getYValueOfXPointByOtherTwo(squareInterpolation.a, squareInterpolation.b, squareInterpolation.c, x);
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
        long uncorrectedValues = Arrays.stream(array).filter(i -> i < 0).count();
        return uncorrectedValues == 0;
    }

    private static Double interpolateLagrangePolynomial(Double x, Double[] xValues, Double[] yValues) {
        double lagrangePol = 0.;
        int size = xValues.length;

        for (int i = 0; i < size; i++) {
            double basicsPol = 1;
            for (int j = 0; j < size; j++) {
                if (j != i) {
                    basicsPol *= (x - xValues[j]) / (xValues[i] - xValues[j]);
                }
            }
            lagrangePol += basicsPol * yValues[i];
        }

        return lagrangePol;
    }

    private static Double getY(Double x) {
        return x * x * x + 3 * x * x + 3 * x + 1;
    }

    public static class SquareInterpolation {
        public final Point a;
        public final Point b;
        public final Point c;

        public SquareInterpolation(Double x1, Double x2, Double x3) {
            this.a = new Point(x1, getY(x1));
            this.b = new Point(x2, getY(x2));
            this.c = new Point(x3, getY(x3));
        }

        public SquareInterpolation(Double x1, Double y1, Double x2, Double y2, Double x3, Double y3) {
            this.a = new Point(x1,y1);
            this.b = new Point(x2,y2);
            this.c = new Point(x3,y3);
        }

        @AllArgsConstructor
        @Getter
        public static class Point {
            Double x;
            Double y;
        }
    }
}
