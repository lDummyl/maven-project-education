package task7;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import task6.LagrangePolynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
@Getter
@Setter
public class Pump implements Comparable<Pump> {
    private String model;
    private Price price; // TODO: 19.01.2021 заведи класс Price


    private List<Speed> speeds = new ArrayList<>();

    public Pump(String model, Double[] consumption, Double[] pressure, Double price) {
        this.model = model;
        this.speeds.add(new Speed(consumption, pressure));
        this.price = new Price(price);
    }

    public Pump() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pump pump = (Pump) o;
        return Objects.equals(model, pump.model) && Objects.equals(price, pump.price) && Objects.equals(speeds, pump.speeds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price, speeds);
    }

    public void addSpeed(Double[] consumption, Double[] pressure) {
        this.speeds.add(new Speed(consumption, pressure));
    }

    @Override
    public int compareTo(Pump o) {
        return this.price.compareTo(o.price);
    }


    public class Speed {
        private Double[] consumption;
        private Double[] pressure;

        public Speed() {
        }

        public Speed(Double[] consumption, Double[] pressure) {
            this.consumption = consumption;
            this.pressure = pressure;
        }

        public Double[] getConsumption() {
            return consumption;
        }

        public void setConsumption(Double[] consumption) {
            this.consumption = consumption;
        }

        public Double[] getPressure() {
            return pressure;
        }

        public void setPressure(Double[] pressure) {
            this.pressure = pressure;
        }

        public Double getPressureValue(Double consumption) {
            LagrangePolynomial lagrangePolynomial = new LagrangePolynomial(this.consumption, this.pressure);
            Double[] cloneConsumption = getConsumption().clone();
            Arrays.sort(cloneConsumption);
            if (consumption > cloneConsumption[cloneConsumption.length - 1] || consumption < cloneConsumption[0]) {
                return Double.MIN_VALUE;
            } else {
                return lagrangePolynomial.getValueY(consumption);
            }
        }

        public Double getConsumptionValue(Double pressure) {
            LagrangePolynomial lagrangePolynomial = new LagrangePolynomial(this.consumption, this.pressure);
            Double[] clonePressure = getPressure().clone();
            Arrays.sort(clonePressure);
            if (pressure > clonePressure[clonePressure.length - 1] || pressure < clonePressure[0]) {
                return Double.MIN_VALUE;
            } else {
                return lagrangePolynomial.getValueX(pressure);
            }
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Speed speed = (Speed) o;
            return Arrays.equals(consumption, speed.consumption) && Arrays.equals(pressure, speed.pressure);
        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(consumption);
            result = 31 * result + Arrays.hashCode(pressure);
            return result;
        }
    }
}
