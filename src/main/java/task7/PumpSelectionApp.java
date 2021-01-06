package task7;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class PumpSelectionApp {


    private final File filePathWithPumps;
    PumpCollector pumpCollector = new PumpCollector();
    PumpSelector pumpSelector = new PumpSelector();

    public PumpSelectionApp(File filePathWithPumps) {
        this.filePathWithPumps = filePathWithPumps;
    }

    public Optional<Pump> selectPump(double consumption, double pressure) {
        pumpCollector.setJsonFile(filePathWithPumps);
        List<Pump> pumps = pumpCollector.deserializeJson();
        return pumpSelector.selectPump( consumption, pressure);
    }
}
