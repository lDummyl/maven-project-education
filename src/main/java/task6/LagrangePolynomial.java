package task6;


public class LagrangePolynomial {
    private double[] xValues;
    private double[] yValues;
    private int size;

    public LagrangePolynomial(double[] xValues, double[] yValues) {
        arraysCheck(xValues, yValues);
        this.xValues = xValues;
        this.yValues = yValues;
        this.size = yValues.length;
    }

    private void arraysCheck(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length || xValues.length == 0) {
            throw new IllegalArgumentException("Wrong Data");
        }
    }

    public LagrangePolynomial(Double[] consumption, Double[] pressure) {
    }

    public void setxValues(double[] xValues) {
        this.xValues = xValues;
    }

    public void setyValues(double[] yValues) {
        this.yValues = yValues;
    }

    public double[] getxValues() {
        return xValues;
    }

    public double[] getyValues() {
        return yValues;
    }

    public double lagrangePolynomial(double x) {
        double polynome = interpolateLagrangePolynomial(x);
        return roudOff(polynome);
    }

    private double roudOff(double polynome) {
        return (double) Math.round(polynome * 1000) / 1000;
    }


    private double interpolateLagrangePolynomial(double x) {
        double lagrangePol = 0;

        for (int i = 0; i < size; i++) {
            double basicsPol = 1;
            for (int j = 0; j < size; j++) {
                if (j != i) {
                    basicsPol *= (x - this.xValues[j]) / (this.xValues[i] - this.xValues[j]);
                }
            }
            lagrangePol += basicsPol * this.yValues[i];
        }

        return lagrangePol;
    }
}
