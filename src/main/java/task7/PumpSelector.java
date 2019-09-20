package task7;

public interface PumpSelector {

    PumpIMP select(Double pressure, Double flow, Double ratioPercent);
}
