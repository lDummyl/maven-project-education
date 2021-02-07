package task7.selector;

import task7.pump.Pump;
import task7.pump.Speed;
import task8.PumpRequest;

import java.util.*;

public class PumpSelector {
    private final TreeSet<Pump> pumpsTree;

    public PumpSelector() {
        PumpCollector collector = new PumpFileCollector();
        pumpsTree = new TreeSet<>(collector.getPumps());
    }


    public Optional<Pump> selectPump(Double consumption, Double pressure) throws PumpSelectorException {
        requestCheck(consumption, pressure);
        return searchPump(consumption, pressure);
    }

    public Optional<Pump> selectPump(PumpRequest request) throws PumpSelectorException {
        Double consumption = request.getConsumption();
        Double pressure = request.getPressure();
        requestCheck(consumption, pressure);
        return searchPump(consumption, pressure);
    }

    private void requestCheck(Double consumption, Double pressure) throws PumpSelectorException {
        if (consumption == null || pressure == null) {
            throw new PumpSelectorException("Null value in request");
        } else if (consumption <= 0 || pressure <= 0) {
            throw new PumpSelectorException("Negative value in request");
        }
    }

    private Optional<Pump> searchPump(Double consumption, Double pressure) {
        for (Pump pump : pumpsTree) {
            if (getWorkSpeed(consumption, pressure, pump).isPresent()) {
                return Optional.of(pump);
            }
        }
        return Optional.empty();
    }

    private Optional<Speed> getWorkSpeed(Double consumption, Double pressure, Pump pump) {
        for (Speed speed : pump.getSpeeds()) {
            Double pressureValue = speed.getPressureValue(consumption);
            if (pressureValue >= pressure) {
                return Optional.of(speed);
            }
        }
        return Optional.empty();
    }
}
