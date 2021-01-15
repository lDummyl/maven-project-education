package newpumpbutchselector;

import newpumpselector.CirculationPumpSelector;
import newpumpselector.CirculationPumpSelectorException;
import task7.Pump;
import task8.PumpRequest;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class CirculationBatchSelector {
    private final CirculationPumpSelector selector;

    public CirculationBatchSelector() {
        this.selector = new CirculationPumpSelector();
    }

    public CirculationPumpBatchReport selectPumpsWithReport(Collection<PumpRequest> requests){
        Collection<CirculationPumpResponse> responses = selectPumps(requests);
        return new CirculationPumpBatchReport(responses);
    }

    public Collection<CirculationPumpResponse> selectPumps(Collection<PumpRequest> requests) {
        return requests.stream().map(this::getCirculationPumpResponse).collect(Collectors.toList());
    }

    private CirculationPumpResponse getCirculationPumpResponse(PumpRequest request) {
        try {
            Optional<Pump> pump = selector.selectPump(request);
            return pump.map(value -> new CirculationPumpResponse(value, request)).orElseGet(() -> new CirculationPumpResponse(request));

        } catch (CirculationPumpSelectorException e) {
            return new CirculationPumpResponse(e);
        }
    }


}
