package task7;

import java.util.*;

public class PumpSelector {
    PumpCollector pumpCollector;

    public PumpSelector(String filePath) {
        this.pumpCollector = new PumpCollector(filePath);
    }

    public Optional<Pump> selectPumpFromFile(String filePath, Double consumption, Double pressure) {
        Collection<Pump> pumps = pumpCollector.deserializeJson();
        return selectPump(pumps, consumption, pressure);
    }

    public PumpSelector() {
    }

    public Optional<Pump> selectPump(Collection<Pump> pumps, Double consumption, Double pressure) {
        ArrayList<Pump> pumpsList = new ArrayList<>(pumps);
        Collections.sort(pumpsList);
        for (Pump pump : pumpsList) {
            if (getWorkSpeed(consumption, pressure, pump).isPresent()) {
                return Optional.of(pump);
            }
        }
        return Optional.empty();
    }

    public Optional<Pump.Speed> getWorkSpeed(Double consumption, Double pressure, Pump pump) {
        for (Pump.Speed speed : pump.getSpeeds()) {
            if (speed.getPressureValue(consumption) >= pressure) {
                return Optional.of(speed);
            }
        }
        return Optional.empty();
    }

}
