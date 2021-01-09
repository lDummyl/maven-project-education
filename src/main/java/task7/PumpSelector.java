package task7;

import task8.PumpRequest;

import java.util.*;

public class PumpSelector {
    Collection<Pump> pumpCollection;


    public PumpSelector() {
        PumpCollector pumpCollector = new PumpCollector();
        pumpCollection = pumpCollector.deserializePumpJson();
    }

    public Optional<Pump> selectPump(PumpRequest request) {
        Double consumption = request.getConsumption();
        Double pressure = request.getPressure();
        if (requestCheck(consumption, pressure)) {
            return pumpSelection(consumption, pressure);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Pump> selectPump(Double consumption, Double pressure) {
        if (requestCheck(consumption, pressure)) {
            return pumpSelection(consumption, pressure);
        } else {
            return Optional.empty();
        }
    }

    private boolean requestCheck(Double consumption, Double pressure) {
        if (consumption == null || pressure == null) {
            return false;
        } else {
            return true;
        }
    }

    private Optional<Pump> pumpSelection(Double consumption, Double pressure) {
        ArrayList<task7.Pump> pumpsList = new ArrayList<>(pumpCollection);
        Collections.sort(pumpsList);
        for (task7.Pump pump : pumpsList) {
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
