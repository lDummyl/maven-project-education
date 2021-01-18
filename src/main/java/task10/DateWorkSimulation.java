package task10;

import task8.PumpPackageSelector;
import task8.PumpReport;
import task8.PumpRequest;

import java.util.ArrayList;
import java.util.List;

public class DateWorkSimulation {
    DatePumpRequestGenerator generator;
    PumpPackageSelector selector;

    public DateWorkSimulation() {
        this.generator = new DatePumpRequestGenerator();
        this.selector = new PumpPackageSelector();
    }

    public List<PumpReport> simulate() {
        // TODO: 16.01.2021 одной строкой, в функциональном стиле, привыкай
//        return generator.generateRequests().stream().map(selector::selectPumpsWithReport)
//                .collect(Collectors.toList());

        ArrayList<PumpReport> pumpReports = new ArrayList<>();
        List<List<PumpRequest>> lists = generator.generateRequests();
        for (List<PumpRequest> list : lists) {
            PumpReport pumpReport = selector.selectPumpsWithReport(list);
            pumpReports.add(pumpReport);
        }
        return pumpReports;
    }
}
