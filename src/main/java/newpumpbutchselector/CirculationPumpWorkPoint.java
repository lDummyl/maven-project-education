package newpumpbutchselector;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CirculationPumpWorkPoint {
    private Double consumption;
    private Double pressure;

    public CirculationPumpWorkPoint(Double consumption, Double pressure) {
        this.consumption = consumption;
        this.pressure = pressure;
    }

}
