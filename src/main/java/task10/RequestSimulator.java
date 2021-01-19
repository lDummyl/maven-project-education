package task10;

import newpumpbutchselector.CirculationPumpBatchReport;
import newpumpbutchselector.CirculationPumpBatchSelector;
import task8.PumpRequest;

import java.util.ArrayList;
import java.util.List;

public class RequestSimulator {
    private final YearPumpRequestGenerator generator;
    private final CirculationPumpBatchSelector selector;

    public RequestSimulator() {
        this.generator = new YearPumpRequestGenerator();
        this.selector = new CirculationPumpBatchSelector();
    }

    public List<CirculationPumpBatchReport> simulate(Integer numberOfReports, Integer numberOfRequests) {
        ArrayList<CirculationPumpBatchReport> reports = new ArrayList<>();
        for (int i = 0; i < numberOfReports; i++) {
            List<PumpRequest> requests = generator.generateRequestList(numberOfRequests);
            reports.add(selector.selectPumpsWithReport(requests));
        }
        return reports;
    }
}
