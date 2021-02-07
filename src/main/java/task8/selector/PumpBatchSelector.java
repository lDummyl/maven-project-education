package task8.selector;

import task7.selector.PumpSelector;
import task7.selector.PumpSelectorException;
import task7.pump.Pump;
import task8.PumpRequest;
import task8.provider.PumpResponseProvider;
import task8.provider.ReportProvider;
import task8.report.PumpBatchReport;
import task8.report.PumpResponse;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class PumpBatchSelector {
    private final PumpSelector selector;
    private final PumpResponseProvider responseProvider;

    public PumpBatchSelector() {
        this.selector = new PumpSelector();
        this.responseProvider = new PumpResponseProvider();
    }

    public PumpBatchReport selectPumpsWithReport(Collection<PumpRequest> requests) {
        Collection<PumpResponse> responses = selectPumps(requests);
        ReportProvider reportProvider = new ReportProvider(responses);
        return reportProvider.createReport();
    }

    public Collection<PumpResponse> selectPumps(Collection<PumpRequest> requests) {
        return requests.stream().map(this::getCirculationPumpResponse).collect(Collectors.toList());
    }

    private PumpResponse getCirculationPumpResponse(PumpRequest request) {
        try {
            Optional<Pump> pump = selector.selectPump(request);
            return responseProvider.createPumpResponse(pump, request);

        } catch (PumpSelectorException e) {
            return responseProvider.createPumpResponse(e, request);
        }
    }
}
