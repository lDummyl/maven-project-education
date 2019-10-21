package task8;

import lombok.Getter;
import task7.PumpMinInfo;

@Getter
public class TechnicalUnit {

    private final PumpMinInfo pump;
    private final Double flow;
    private final Double pressure;
    private final Pair workPoint;

    public TechnicalUnit(PumpMinInfo pump, Double flow, Double pressure, Pair workPoint) {
        this.pump = pump;
        this.flow = flow;
        this.pressure = pressure;
        this.workPoint = workPoint;
    }
}
