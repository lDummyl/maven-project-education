package task7;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.List;


@JsonAutoDetect
public class Pump implements Serializable {
    private String model;
    private List<Speed> speeds;
    private Double rublePrice;


    public class Speed {
        private Double[] consumption;
        private Double[] pressure;

        public Speed(Double[] consumption, Double[] pressure) {
            this.consumption = consumption;
            this.pressure = pressure;
        }
    }
}
