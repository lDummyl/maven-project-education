package task7;

import java.util.*;
import java.util.stream.Collectors;

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
        Collection<PumpVariant> pumpVariants = pumps.stream().map(value -> new PumpVariant(value, consumption, pressure)).sorted().collect(Collectors.toList());
        for (PumpVariant pumpVariant : pumpVariants) {
            if (pumpVariant.deviationOfPressure >= 0) {
                System.out.println();
                return Optional.of(pumpVariant.pump);
            }
        }

        return Optional.empty();
    }
}
