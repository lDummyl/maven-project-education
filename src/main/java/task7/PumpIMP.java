package task7;

import task6.LagrangePolynomial;
import task8.Pair;

public class PumpIMP implements Pump {

    private String name;
    private Double price;
//    private String function;
//    private Double[] functionArgsX;
//    private Double[] functionArgsY;
    private LagrangePolynomial.SquareInterpolation squareInterpolation;
    private Pair workPoint = new Pair(0., 0.);

//    public PumpIMP(String name, Double price, String function, Double[] functionArgsX) {
//        this.name = name;
//        this.price = price;
//        this.function = function;
//        this.functionArgsX = functionArgsX;
//        this.functionArgsY = new Double[]{};
//    }

    public PumpIMP(String name, Double price, String function, LagrangePolynomial.SquareInterpolation squareInterpolation) {
        this.name = name;
        this.price = price;
//        this.function = function;
        this.squareInterpolation = squareInterpolation;
    }

//    public Double calculateConsumption(Double flow) {
//        if (functionArgsY.length != 0 && functionArgsX.length == functionArgsY.length) {
//            return LagrangePolynomial.getLagrangePolynomial(functionArgsX, functionArgsY, flow);
//        } else {
//            return LagrangePolynomial.getLagrangePolynomial(functionArgsX, flow);
//        }
//    }

    @Override
    public Double calculateWorkPoint(Double flow, Double pressure) {
        workPoint = LagrangePolynomial.getWorkPointEquationSquare(squareInterpolation, flow, pressure);
        return workPoint.getFlow();
    }

//    private Double[] getArgsX(LagrangePolynomial.SquareInterpolation squareInterpolation) {
//        return new Double[]{squareInterpolation.a.getX(), squareInterpolation.b.getX(), squareInterpolation.c.getX()};
//    }
//
//    private Double[] getArgsY(LagrangePolynomial.SquareInterpolation squareInterpolation) {
//        return new Double[]{squareInterpolation.a.getY(), squareInterpolation.b.getY(), squareInterpolation.c.getY()};
//    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

//    public String getFunction() {
//        return function;
//    }
//
//    public Double[] getFunctionArgsX() {
//        return functionArgsX;
//    }
//
//    public Double[] getFunctionArgsY() {
//        return functionArgsY;
//    }


    public LagrangePolynomial.SquareInterpolation getSquareInterpolation() {
        return squareInterpolation;
    }

    public Pair getWorkPoint() {
        return workPoint;
    }

    public void setWorkPoint(Pair workPoint) {
        this.workPoint = workPoint;
    }
}
