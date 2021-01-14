package newpumpselector;

import task7.Pump;
import task8.PumpRequest;

import java.util.*;

public class CirculationPumpSelector {
    private final CirculationPumpCollector collector;
    private final List<Pump> pumpList;

    public CirculationPumpSelector() {
        this.collector = new CirculationPumpFileCollector();
        pumpList = new ArrayList<>(collector.getPumps());
    }


    public Optional<Pump> selectPump(Double consumption, Double pressure) throws CirculationPumpSelectorException {
        requestCheck(consumption, pressure);
        return searchPump(consumption, pressure);
    }

    public Optional<Pump> selectPump(PumpRequest request) throws CirculationPumpSelectorException {
        Double consumption = request.getConsumption();
        Double pressure = request.getPressure();
        requestCheck(consumption, pressure);
        return searchPump(consumption, pressure);
    }

    private void requestCheck(Double consumption, Double pressure) throws CirculationPumpSelectorException {
        if (consumption == null || pressure == null) {
            throw new CirculationPumpSelectorException("Null value in request");
        } else if (consumption <= 0 || pressure <= 0) {
            throw new CirculationPumpSelectorException("Negative value in request");
        }
    }

    private Optional<Pump> searchPump(Double consumption, Double pressure) {
        pumpList.sort(Pump::compareTo);
        for (task7.Pump pump : pumpList) {
            if (getWorkSpeed(consumption, pressure, pump).isPresent()) {
                return Optional.of(pump);
            }
        }
        return Optional.empty();
    }

    private Optional<Pump.Speed> getWorkSpeed(Double consumption, Double pressure, Pump pump) {
        for (Pump.Speed speed : pump.getSpeeds()) {
            Double pressureValue = speed.getPressureValue(consumption);
            if (pressureValue >= pressure) {
                return Optional.of(speed);
            }
        }
        return Optional.empty();
    }
}
