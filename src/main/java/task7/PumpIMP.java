package task7;

import task6.LagrangePolynomial;

public class PumpIMP implements Pump {

    private String name;
    private Double price;
    private String function;
    private Double[] functionArgsX;
    private Double[] functionArgsY;

    public PumpIMP(String name, Double price, String function, Double[] functionArgsX) {
        this.name = name;
        this.price = price;
        this.function = function;
        this.functionArgsX = functionArgsX;
        this.functionArgsY = new Double[]{};
    }

    public PumpIMP(String name, Double price, String function, LagrangePolynomial.SquareInterpolation squareInterpolation) {
        this.name = name;
        this.price = price;
        this.function = function;
        this.functionArgsX = getArgsX(squareInterpolation);
        this.functionArgsY = getArgsY(squareInterpolation);
    }

    @Override
    public Double calculateConsumption(Double flow) {
        if (functionArgsY.length != 0 && functionArgsX.length == functionArgsY.length) {
            return LagrangePolynomial.getLagrangePolynomial(functionArgsX, functionArgsY, flow);
        } else {
            return LagrangePolynomial.getLagrangePolynomial(functionArgsX, flow);
        }
    }

    public Double calculateWorkPoint(Double pressure, Double flow) {
        return LagrangePolynomial.getLagrangePolynomial(new Double[]{0., pressure}, new Double[]{0., flow}, flow);
    }

    private Double[] getArgsX(LagrangePolynomial.SquareInterpolation squareInterpolation) {
        return new Double[]{squareInterpolation.a.getX(), squareInterpolation.b.getX(), squareInterpolation.c.getX()};
    }

    private Double[] getArgsY(LagrangePolynomial.SquareInterpolation squareInterpolation) {
        return new Double[]{squareInterpolation.a.getY(), squareInterpolation.b.getY(), squareInterpolation.c.getY()};
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getFunction() {
        return function;
    }

    public Double[] getFunctionArgsX() {
        return functionArgsX;
    }

    public Double[] getFunctionArgsY() {
        return functionArgsY;
    }
}
