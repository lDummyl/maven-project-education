package task7;

import task6.LagrangePolynomial;
import task8.Pair;

public class PumpIMP implements Pump {

    private String name;
    private Double price;
    private LagrangePolynomial.SquareInterpolation squareInterpolation;
    private Pair workPoint = new Pair(0., 0.);

    public PumpIMP(String name, Double price, LagrangePolynomial.SquareInterpolation squareInterpolation) {
        this.name = name;
        this.price = price;
        this.squareInterpolation = squareInterpolation;
    }

    @Override
    public Double calculateWorkPoint(Double flow, Double pressure) {
        workPoint = LagrangePolynomial.getWorkPointEquationSquare(squareInterpolation, flow, pressure);
        return workPoint.getFlow();
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

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
