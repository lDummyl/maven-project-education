package task6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import task7.ErrorMessage;
import task7.RuntimeExceptionImp;
import task8.Pair;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

    public static Pair getWorkPointEquationSquare(SquareInterpolation squareInterpolation, Double flow, Double pressure) {
        CoefficientsEquationSquare equationSquare = getSqrCoefficients(squareInterpolation);
        return getWorkPoint(equationSquare, flow, pressure);
    }

    private static CoefficientsEquationSquare getSqrCoefficients(SquareInterpolation squareInterpolation) {
        SquareInterpolation.Point a = squareInterpolation.a;
        SquareInterpolation.Point b = squareInterpolation.b;
        SquareInterpolation.Point c = squareInterpolation.c;

        CoefficientsEquationSquare firstIndicators = getIndicators(a.x, b.x, c.x);
        CoefficientsEquationSquare secondIndicators = getIndicators(b.x, a.x, c.x);
        CoefficientsEquationSquare thirdIndicators = getIndicators(c.x, a.x, b.x);

        List<CoefficientsEquationSquare> indicators = Stream.of(firstIndicators, secondIndicators, thirdIndicators).collect(Collectors.toList());
        List<Double> indicatorsA = indicators.stream().map(CoefficientsEquationSquare::getA).collect(Collectors.toList());
        List<Double> indicatorsB = indicators.stream().map(CoefficientsEquationSquare::getB).collect(Collectors.toList());
        List<Double> indicatorsC = indicators.stream().map(CoefficientsEquationSquare::getC).collect(Collectors.toList());

        List<Double> yS = squareInterpolation.getYs();

        Double firstAll = getMultipliedIndicators(yS, indicatorsA);
        Double secondAll = getMultipliedIndicators(yS, indicatorsB);
        Double thirdAll = getMultipliedIndicators(yS, indicatorsC);

        return new CoefficientsEquationSquare(firstAll, secondAll, thirdAll);
    }

    private static Double getMultipliedIndicators(SquareInterpolation.Point a, SquareInterpolation.Point b, SquareInterpolation.Point c, List<Double> indicatorsX) {
        return getRoundDouble(indicatorsX.get(0) * a.y + indicatorsX.get(1) * b.y + indicatorsX.get(2) * c.y);
    }

    private static Double getMultipliedIndicators(List<Double> yS, List<Double> indicatorsX) {
        double result = 0.;
        if (yS.size() != indicatorsX.size()) {
            throw new RuntimeExceptionImp(ErrorMessage.LIST_SIZES_MISMATCH);
        }
        for (int i = 0; i < yS.size(); i++) {
            result += yS.get(i) * indicatorsX.get(i);
        }
        return getRoundDouble(result);
    }

    private static CoefficientsEquationSquare getIndicators(double x1, double x2, double x3) {
        double divider = (x1 - x2) * (x1 - x3);
        double first = 1. / divider;
        double second = (-x2 - x3) / divider;
        double third = (x2 * x3) / divider;

        return new CoefficientsEquationSquare(first, second, third);
    }

    private static Double getRoundDouble(double number) {
        BigDecimal bigDecimal = new BigDecimal(number);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private static Pair getWorkPoint(CoefficientsEquationSquare equationSquare, Double flow, Double pressure) {
        if (!checkCoefficientsCorrect(equationSquare)) {
            throw new RuntimeExceptionImp(ErrorMessage.ZERO_VALUE);
        }

        double a = equationSquare.a;
        double b = equationSquare.b;
        double c = equationSquare.c;
        double d = pressure / flow;
        double y;
        Double x = 0.;

        double D = b * b - 4 * a * c;
        if (D > 0) {
            double y1, y2;
            y1 = (-b - Math.sqrt(D)) / (2 * a);
            y2 = (-b + Math.sqrt(D)) / (2 * a);
            y = Math.max(y1, y2);
        } else if (D == 0) {
            y = -b / (2 * a);
        } else {
            y = 0.;
        }

        if (y != 0.) {
            x = getRoundDouble(y / d);
            y = getRoundDouble(y);
        }

        return new Pair(x, y);
    }

    private static Boolean checkCoefficientsCorrect(CoefficientsEquationSquare equationSquare) {
        return equationSquare.a != 0.;
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
            this.a = new Point(x1, y1);
            this.b = new Point(x2, y2);
            this.c = new Point(x3, y3);
        }

        public  List<Double> getYs (){
             return Stream.of(a, b, c).map(SquareInterpolation.Point::getY).collect(Collectors.toList());
        }


        @AllArgsConstructor
        @Getter
        public static class Point {
            Double x;
            Double y;
        }
    }
}
