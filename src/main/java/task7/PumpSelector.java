package task7;

import task6.LagrangePolynomial;

import java.util.*;

public class PumpSelector {

    public Pump selectPump(Collection<Pump> pumps, Double consumption, Double pressure) {
        TreeSet<pumpVariant> pumpVariants = new TreeSet<>();
        for (Pump p : pumps) {
            pumpVariants.add(new pumpVariant(p, consumption, pressure));
        }
        return pumpVariants.first().pump;
    }

    private class pumpVariant implements Comparable<pumpVariant> {
        Pump pump;
        Double price;
        Double bestDiff;

        public pumpVariant(Pump pump, Double consumption, Double pressure) {
            this.pump = pump;
            this.price = this.pump.getRublePrice();
            this.bestDiff = searchMinimalDiff(consumption, pressure);
        }

        public Double searchMinimalDiff(Double consumption, Double pressure) {
            ArrayList<Double> diffrecncies = new ArrayList<>();
            List<Pump.Speed> speeds =  pump.getSpeeds();
            for (Pump.Speed speed : speeds) {
                LagrangePolynomial lagrangePolynomial = new LagrangePolynomial(speed.getConsumption(), speed.getPressure());
                double current = lagrangePolynomial.lagrangePolynomial(consumption);
                diffrecncies.add(Math.abs(current - pressure));
            }
            Collections.sort(diffrecncies);
            return diffrecncies.get(0);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            pumpVariant that = (pumpVariant) o;
            return Objects.equals(pump, that.pump) && Objects.equals(price, that.price) && Objects.equals(bestDiff, that.bestDiff);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pump, price, bestDiff);
        }

        @Override
        public int compareTo(pumpVariant o) {
            return this.bestDiff.compareTo(o.bestDiff) * 5 + this.price.compareTo(o.price);
        }
    }

}
