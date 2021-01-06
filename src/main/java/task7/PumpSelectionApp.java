package task7;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class PumpSelectionApp {


    private String filePathWithPumps;
    PumpCollector pumpCollector = new PumpCollector();
    PumpSelector pumpSelector = new PumpSelector();

    public PumpSelectionApp(String filePathWithPumps) {
        this.filePathWithPumps = filePathWithPumps;
    }

    public Optional<Pump> selectPump(double consumption, double pressure) {
        pumpCollector.setJsonFile(new File(filePathWithPumps));
        List<Pump> pumps = pumpCollector.deserializeJson();
        return pumpSelector.selectPump( consumption, pressure);
    }
}
