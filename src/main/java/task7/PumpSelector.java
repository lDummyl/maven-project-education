package task7;

import task8.PumpRequest;

import java.util.*;

public class PumpSelector {
    Collection<Pump> pumpCollection;


    public PumpSelector() {
        PumpCollector pumpCollector = new PumpCollector();
        pumpCollection = pumpCollector.deserializePumpJson();
    }

    public Optional<Pump> selectPump(Double consumption, Double pressure) {
        ArrayList<Pump> pumpsList = new ArrayList<>(pumpCollection);
        Collections.sort(pumpsList);
        for (Pump pump : pumpsList) {
            if (getWorkSpeed(consumption, pressure, pump).isPresent()) {
                return Optional.of(pump);
            }
        }
        return Optional.empty();
    }

    public Optional<Pump> selectPump(PumpRequest request) {
        ArrayList<task7.Pump> pumpsList = new ArrayList<>(pumpCollection);
        Collections.sort(pumpsList);
        for (task7.Pump pump : pumpsList) {
            if (getWorkSpeed(request.getConsumption(), request.getPressure(), pump).isPresent()) {
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
