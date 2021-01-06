package task7;

import java.io.File;
import java.util.*;

public class PumpSelector {
    private final PumpCollector pumpCollector;
    Collection<Pump> pumpCollection;

    public PumpSelector(String filePath) {
        this.pumpCollector = new PumpCollector(filePath);
    }

   /* public Optional<Pump> selectPumpFromFile(String filePath, Double consumption, Double pressure) {
        Collection<Pump> pumps = pumpCollector.deserializeJson();
        return selectPump(pumps, consumption, pressure);
    }
    */

    public PumpSelector() {
        pumpCollector = new PumpCollector();
        pumpCollection = pumpCollector.deserializeJson();
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

    public Optional<Pump.Speed> getWorkSpeed(Double consumption, Double pressure, Pump pump) {
        for (Pump.Speed speed : pump.getSpeeds()) {
            Double pressureValue = speed.getPressureValue(consumption);
            if (pressureValue >= pressure) {
                return Optional.of(speed);
            }
        }
        return Optional.empty();
    }

}
