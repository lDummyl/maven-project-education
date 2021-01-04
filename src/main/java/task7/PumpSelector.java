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
            List<Pump.Speed> speeds = pump.getSpeeds();
            for (Pump.Speed speed : speeds) {
                if (speed.getPressureValue(consumption) >= pressure) {
                    return Optional.of(pump);
                }
            }
        }
        return Optional.empty();
    }
}
