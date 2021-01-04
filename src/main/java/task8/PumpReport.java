package task8;


import task7.Pump;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PumpReport {
    List<Pump> pumpsList;
    Collection<PumpRequest> pumpRequests;
    Collection<ChosenPump> chosenPumps;
    PumpCommercialBlock commercialBlock;

    public PumpReport(List<Pump> pumpsList, Collection<PumpRequest> pumpRequests) {
        this.pumpsList = pumpsList;
        this.pumpRequests = pumpRequests;
        this.chosenPumps = choosePumps();
        this.commercialBlock = new PumpCommercialBlock(this.chosenPumps);
    }

    private Collection<ChosenPump> choosePumps() {
       return this.pumpRequests.stream().map(value -> new ChosenPump(value, this.pumpsList)).collect(Collectors.toList());
    }
}
