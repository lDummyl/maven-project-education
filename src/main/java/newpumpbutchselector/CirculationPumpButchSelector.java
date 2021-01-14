package newpumpbutchselector;

import newpumpselector.CirculationPumpSelector;
import newpumpselector.CirculationPumpSelectorException;
import task7.Pump;
import task8.PumpRequest;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CirculationPumpButchSelector {
    private CirculationPumpSelector selector;


    public Collection<CirculationPumpResponse> selectPumps(Collection<PumpRequest> requests) {
       return null;
    }
    private Optional<Pump> onePumpSearch(PumpRequest request){
        try {
            selector.selectPump(request);
        } catch (CirculationPumpSelectorException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}
