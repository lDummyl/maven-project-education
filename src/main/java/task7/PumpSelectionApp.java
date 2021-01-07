package task7;

import java.io.File;
import java.util.Optional;
import java.util.Set;

public class PumpSelectionApp {


    private final File filePathWithPumps;
    PumpCollector pumpCollector = new PumpCollector();
    PumpSelector pumpSelector = new PumpSelector();

    public PumpSelectionApp(File filePathWithPumps) {
        this.filePathWithPumps = filePathWithPumps;
    }

    public Optional<Pump> selectPump(double consumption, double pressure) {
        pumpCollector.setJsonPumpFile(filePathWithPumps);
        Set<Pump> pumps = pumpCollector.deserializePumpJson();
        return pumpSelector.selectPump(consumption, pressure);
    }
}
