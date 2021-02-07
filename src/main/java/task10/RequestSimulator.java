package task10;

import task8.report.PumpBatchReport;
import task8.selector.PumpBatchSelector;
import task8.PumpRequest;

import java.util.ArrayList;
import java.util.List;

public class RequestSimulator {
    private final YearPumpRequestGenerator generator;
    private final PumpBatchSelector selector;

    public RequestSimulator() {
        this.generator = new YearPumpRequestGenerator();
        this.selector = new PumpBatchSelector();
    }

    public List<PumpBatchReport> simulate(Integer numberOfReports, Integer numberOfRequests) {
        ArrayList<PumpBatchReport> reports = new ArrayList<>();
        for (int i = 0; i < numberOfReports; i++) {
            List<PumpRequest> requests = generator.generateRequestList(numberOfRequests);
            reports.add(selector.selectPumpsWithReport(requests));
        }
        return reports;
    }
}
