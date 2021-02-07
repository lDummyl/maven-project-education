package task8;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PumpWorkPoint {
    private Double consumption;
    private Double pressure;

    public PumpWorkPoint(Double consumption, Double pressure) {
        this.consumption = consumption;
        this.pressure = pressure;
    }
}
