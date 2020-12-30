package task7;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.*;


@JsonInclude
@JsonAutoDetect
public class Pump {
    @JsonProperty
    private String model;
    @JsonProperty
    private Double rublePrice;

    @JsonProperty
    private List<Speed> speeds = new ArrayList<>();

    public Pump(String model, Double[] consumption, Double[] pressure, Double rublePrice) {
        this.model = model;
        this.speeds.add(new Speed(consumption, pressure));
        this.rublePrice = rublePrice;
    }

    public Pump() {
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

    public List<Speed> getSpeeds() {
        return speeds;
    }

    public void setSpeeds(List<Speed> speeds) {
        this.speeds = speeds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pump pump = (Pump) o;
        return Objects.equals(model, pump.model) && Objects.equals(rublePrice, pump.rublePrice) && Objects.equals(speeds, pump.speeds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, rublePrice, speeds);
    }

    public void addSpeed(Double[] consumption, Double[] pressure) {
        this.speeds.add(new Speed(consumption, pressure));
    }

    @JsonInclude
    @JsonAutoDetect
    static class Speed {
        @JsonProperty
        private Double[] consumption;
        @JsonProperty
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
