package task7;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class PumpSelector {
    PumpCollector pumpCollector;

    public PumpSelector(String filePath) {
        this.pumpCollector = new PumpCollector(filePath);
    }

    public Pump selectPumpFromFile(String filePath, Double consumption, Double pressure){
        Collection<Pump> pumps = pumpCollector.deserializeJson();
        return selectPump(pumps, consumption, pressure);
    }

    public Pump selectPump(Collection<Pump> pumps, Double consumption, Double pressure) {
        List<PumpVariant> pumpVariants = pumps.stream().map(value -> new PumpVariant(value, consumption, pressure)).collect(Collectors.toList());
        Collections.sort(pumpVariants);
        for (PumpVariant pumpVariant : pumpVariants) {
            if (pumpVariant.bestDiff >= 0) {
                return pumpVariant.pump;
            }
        }
        throw new IllegalArgumentException("There is no suitable pump");
    }
}
