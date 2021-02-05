package newpumpbutchselector;

import newpumpselector.CirculationPumpSelector;
import newpumpselector.CirculationPumpSelectorException;
import task7.Pump;
import task8.PumpRequest;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class CirculationPumpBatchSelector {
    private final CirculationPumpSelector selector;
    private final PumpResponseProvider responseProvider;

    public CirculationPumpBatchSelector() {
        this.selector = new CirculationPumpSelector();
        this.responseProvider = new PumpResponseProvider();
    }

    public CirculationPumpBatchReport selectPumpsWithReport(Collection<PumpRequest> requests) {
        Collection<CirculationPumpResponse> responses = selectPumps(requests);
        ReportProvider reportProvider = new ReportProvider(responses);
        return reportProvider.createReport();
    }

    public Collection<CirculationPumpResponse> selectPumps(Collection<PumpRequest> requests) {
        return requests.stream().map(this::getCirculationPumpResponse).collect(Collectors.toList());
    }

    private CirculationPumpResponse getCirculationPumpResponse(PumpRequest request) {
        try {
            Optional<Pump> pump = selector.selectPump(request);
            return responseProvider.createPumpResponse(pump, request);

        } catch (CirculationPumpSelectorException e) {
            return responseProvider.createPumpResponse(e, request);
        }
    }

    public void selectPumps() {

    }
}
