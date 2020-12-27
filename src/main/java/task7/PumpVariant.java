package task7;

import task6.LagrangePolynomial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PumpVariant implements Comparable<PumpVariant> {
    Pump pump;
    Double price;
    Double bestDiff;

    public PumpVariant(Pump pump, Double consumption, Double pressure) {
        this.pump = pump;
        this.price = this.pump.getRublePrice();
        this.bestDiff = searchMinimalDiff(consumption, pressure);
    }

    private Double searchMinimalDiff(Double consumption, Double pressure) {
        ArrayList<Double> difference = new ArrayList<>();
        List<Pump.Speed> speeds = this.pump.getSpeeds();
        for (Pump.Speed speed : speeds) {
            LagrangePolynomial lagrangePolynomial = new LagrangePolynomial(speed.getConsumption(), speed.getPressure());
            double current = lagrangePolynomial.getValue(consumption);
            double differenceValue = current - pressure;
            difference.add(differenceValue);
            System.out.println();
        }
        Collections.sort(difference);
        return difference.get(difference.size()-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PumpVariant that = (PumpVariant) o;
        return Objects.equals(pump, that.pump) && Objects.equals(price, that.price) && Objects.equals(bestDiff, that.bestDiff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pump, price, bestDiff);
    }

    @Override
    public int compareTo(PumpVariant o) {
        return this.price.compareTo(o.price);
    }
}