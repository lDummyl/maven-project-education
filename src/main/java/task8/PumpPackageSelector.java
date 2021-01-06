package task8;

import task7.Pump;
import task7.PumpSelector;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class PumpPackageSelector {
    PumpSelector pumpSelector = new PumpSelector();

    public PumpPackageSelector() {
        this.pumpSelector = new PumpSelector();
    }

    public PumpPackageSelector(PumpSelector pumpSelector) {
        this.pumpSelector = new PumpSelector();
    }


    public PumpReport selectPumpsWithReport(Collection<PumpRequest> requests) {
        List<PumpTechResponse> pumpTechResponses = selectPumps(requests);
        return new PumpReport(pumpTechResponses);
    }

    public List<PumpTechResponse> selectPumps(Collection<PumpRequest> requests) {
        ArrayList<PumpTechResponse> pumps = new ArrayList<>();
        for (PumpRequest request : requests) {
            Optional<Pump> pump = pumpSelector.selectPump(request);
            pumps.add(new PumpTechResponse(request, pump));
        }
        return pumps;
    }

}
