package task8;

import lombok.Getter;
import task7.PumpIMP;

@Getter
public class TechnicalUnit {

    private final PumpIMP pump;
    private final Double pressure;
    private final Double flow;
    private final Pair workPoint;

    public TechnicalUnit(PumpIMP pump, Double pressure, Double flow, Pair workPoint) {
        this.pump = pump;
        this.pressure = pressure;
        this.flow = flow;
        this.workPoint = workPoint;
    }
}
