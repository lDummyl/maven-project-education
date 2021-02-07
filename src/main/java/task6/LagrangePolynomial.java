package task6;


import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class LagrangePolynomial {
    private List<Double> xValues;
    private List<Double> yValues;
    private int size;

    public LagrangePolynomial(Double[] xValues, Double[] yValues) {
        dataCheck(xValues, yValues);
        this.xValues = Arrays.asList(xValues.clone());
        this.yValues = Arrays.asList(yValues.clone());
        this.size = yValues.length;
    }

    public LagrangePolynomial(double[] xValues, double[] yValues) {
        dataCheck(xValues, yValues);
        this.xValues = Arrays.stream(xValues).boxed().collect(Collectors.toList());
        this.yValues = Arrays.stream(yValues).boxed().collect(Collectors.toList());
        this.size = yValues.length;
    }

    public LagrangePolynomial(List<Double> xValues, List<Double> yValues) {
        dataCheck(xValues, yValues);
        this.xValues = xValues;
        this.yValues = yValues;
        this.size = yValues.size();
    }


    private void dataCheck(Double[] xValues, Double[] yValues) {
        if (xValues.length != yValues.length || xValues.length == 0) {
            throw new IllegalArgumentException("Wrong Data");
        }
    }

    private void dataCheck(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length || xValues.length == 0) {
            throw new IllegalArgumentException("Wrong Data");
        }
    }

    private void dataCheck(List<Double> xValues, List<Double> yValues) {
        if (xValues.size() != yValues.size() || xValues.size() == 0) {
            throw new IllegalArgumentException("Wrong Data");
        }
    }

    private Double roundOf(double polynome) {
        return (double) Math.round(polynome * 1000) / 1000;
    }


    public Double getValueX(Double y) {
        return getValue(y, this.yValues, this.xValues);
    }

    public Double getValueY(Double x) {
        return getValue(x, this.xValues, this.yValues);
    }

    private Double getValue(Double value, List<Double> firstPoints, List<Double> secondPoints) {
        double lagrangePol = 0;
        for (int i = 0; i < size; i++) {
            double basicsPol = 1;
            for (int j = 0; j < size; j++) {
                if (j != i) {
                    basicsPol *= (value - firstPoints.get(j)) / (firstPoints.get(i) - firstPoints.get(j));
                }
            }
            lagrangePol += basicsPol * secondPoints.get(i);
        }
        return roundOf(lagrangePol);
    }
}
