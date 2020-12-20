package task7;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


import java.util.Arrays;


@JsonAutoDetect
public class Pump {
    private String model;
    private Double rublePrice;
    private Speed[] speeds = new Speed[3];

    public Pump(String model, Double[] consumption, Double[] pressure, Double rublePrice) {
        this.model = model;
        this.speeds[0] = new Speed(consumption, pressure);
        this.rublePrice = rublePrice;
    }

    public Pump() {
    }

    public void addSpeed(Double[] consumption, Double[] pressure){
        if (speeds[1] == null){
            speeds[1] = new Speed(consumption, pressure);
        }
        else if (speeds[2] == null){
            speeds[2] = new Speed(consumption, pressure);
        }
        else {
            throw new IllegalArgumentException("Больше скоростей добавть нельзя");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getRublePrice() {
        return rublePrice;
    }

    public void setRublePrice(Double rublePrice) {
        this.rublePrice = rublePrice;
    }

    public Speed[] getSpeeds() {
        return speeds;
    }

    public void setSpeeds(Speed[] speeds) {
        this.speeds = speeds;
    }

    private class Speed {
        private Double[] consumption;
        private Double[] pressure;

        public Speed(Double[] consumption, Double[] pressure) {
            this.consumption = consumption;
            this.pressure = pressure;
        }

        public Speed() {
        }

        public void setConsumption(Double[] consumption) {
            this.consumption = consumption;
        }

        public void setPressure(Double[] pressure) {
            this.pressure = pressure;
        }

        public Double[] getConsumption() {
            return consumption;
        }

        public Double[] getPressure() {
            return pressure;
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
