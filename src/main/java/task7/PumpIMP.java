package task7;

import task6.LagrangePolynomial;

public class PumpIMP implements Pump {

    private String name;
    private Double price;
    private String function; // так как механизм подбора изменился, я теперь до конца не понимаю для чего нам надо хранить это значение
    private Double[] functionArgsX;
    private Double[] functionArgsY;

    public PumpIMP(String name, Double price, String function, Double[] functionArgsX) {
        this.name = name;
        this.price = price;
        this.function = function;
        this.functionArgsX = functionArgsX;
        this.functionArgsY = new Double[]{};
    }

    public PumpIMP(String name, Double price, String function, Double[] functionArgsX, Double[] functionArgsY) {
        this.name = name;
        this.price = price;
        this.function = function;
        this.functionArgsX = functionArgsX;
        this.functionArgsY = functionArgsY;
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

    public static void main(String[] args) {
        System.out.println(LagrangePolynomial.getLagrangePolynomial(new Double[]{0.,2.}, new Double[]{0., 4.}, 6.));
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
