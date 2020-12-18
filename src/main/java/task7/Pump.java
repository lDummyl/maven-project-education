package task7;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@JsonAutoDetect
public class Pump implements Serializable {
    private String model;
    private Map<Integer, Speed> speedMap;
    private Double rublePrice;

    public Pump(String model, Map<Integer, Speed> speedMap, Double rublePrice) {
        this.model = model;
        this.speedMap = speedMap;
        this.rublePrice = rublePrice;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeedMap(Map<Integer, Speed> speedMap) {
        this.speedMap = speedMap;
    }

    public void setRublePrice(Double rublePrice) {
        this.rublePrice = rublePrice;
    }

    public String getModel() {
        return model;
    }

    public Map<Integer, Speed> getSpeedMap() {
        return speedMap;
    }

    public Double getRublePrice() {
        return rublePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pump pump = (Pump) o;
        return Objects.equals(model, pump.model) && Objects.equals(speedMap, pump.speedMap) && Objects.equals(rublePrice, pump.rublePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, speedMap, rublePrice);
    }

    private class Speed {
        private Double[] consumption;
        private Double[] pressure;
    }
}
