package task7;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@JsonAutoDetect
public class Pump implements Serializable {
    private String model;
    private Double[] consumption;
    private Double[] pressure;
    private Double rublePrice;

    public Pump(String model, Double[] consumption, Double[] pressure, Double rublePrice) {
        this.model = model;
        this.consumption = consumption;
        this.pressure = pressure;
        this.rublePrice = rublePrice;
    }

    public Pump() {
    }

    public String getModel() {
        return model;
    }

    public Double[] getConsumption() {
        return consumption;
    }

    public Double[] getPressure() {
        return pressure;
    }

    public Double getRublePrice() {
        return rublePrice;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setConsumption(Double[] consumption) {
        this.consumption = consumption;
    }

    public void setPressure(Double[] pressure) {
        this.pressure = pressure;
    }

    public void setRublePrice(Double rublePrice) {
        this.rublePrice = rublePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pump pump = (Pump) o;
        return Objects.equals(model, pump.model) && Arrays.equals(consumption, pump.consumption) && Arrays.equals(pressure, pump.pressure) && Objects.equals(rublePrice, pump.rublePrice);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(model, rublePrice);
        result = 31 * result + Arrays.hashCode(consumption);
        result = 31 * result + Arrays.hashCode(pressure);
        return result;
    }
}
