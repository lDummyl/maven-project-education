package task6;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class LagrangePolynomial {
    private  List<Double> xValues;
    private  List<Double> yValues;
    private  int size;

    public LagrangePolynomial(Double[] xValues, Double[] yValues) {
        arraysCheck(xValues, yValues);
        this.xValues = Arrays.asList(xValues.clone());
        this.yValues = Arrays.asList(yValues.clone());
        this.size = yValues.length;
    }
    public LagrangePolynomial(double[] xValues, double[] yValues) {
        this.xValues = Arrays.stream(xValues).boxed().collect(Collectors.toList());
        this.yValues = Arrays.stream(yValues).boxed().collect(Collectors.toList());
        this.size = yValues.length;
    }

    public List<Double> getxValues() {
        return xValues;
    }

    public void setxValues(List<Double> xValues) {
        this.xValues = xValues;
    }

    public List<Double> getyValues() {
        return yValues;
    }

    public void setyValues(List<Double> yValues) {
        this.yValues = yValues;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private void arraysCheck(Double[] xValues, Double[] yValues) {
        if (xValues.length != yValues.length || xValues.length == 0) {
            throw new IllegalArgumentException("Wrong Data");
        }
    }
    private void arraysCheck(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length || xValues.length == 0) {
            throw new IllegalArgumentException("Wrong Data");
        }
    }


    public double getValue(double x) {
        double polynome = interpolateLagrangePolynomial(x);
        return roudOff(polynome);
    }

    private Double roudOff(double polynome) {
        return (double) Math.round(polynome * 1000) / 1000;
    }


    private Double interpolateLagrangePolynomial(double x) {
        double lagrangePol = 0;

        for (int i = 0; i < size; i++) {
            double basicsPol = 1;
            for (int j = 0; j < size; j++) {
                if (j != i) {
                    basicsPol *= (x - this.xValues.get(j)) / (this.xValues.get(i) - this.xValues.get(j));
                }
            }
            lagrangePol += basicsPol * this.yValues.get(i);
        }

        return lagrangePol;
    }
}
