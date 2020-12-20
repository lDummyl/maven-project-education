package task7;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonAutoDetect
public class Pump {
    private String model;
    private Double rublePrice;

    @JsonProperty("list")
    private List<Speed> speeds = new ArrayList<>();

    public Pump(String model, Double[] consumption, Double[] pressure, Double rublePrice) {
        this.model = model;
        this.speeds.add(new Speed(consumption, pressure));
        this.rublePrice = rublePrice;
    }


    private class Speed{
        private Double[] consumption;
        private Double[] pressure;

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
    }
}
