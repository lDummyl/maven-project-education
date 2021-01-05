package task8;


import task7.Pump;
import task7.PumpSelector;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PumpReport {
    private List<Pump> pumpsList;
    private Collection<PumpRequest> pumpRequests;
    private List<PumpTechResponse> pumpTechResponses;
    private PumpCommercialBlock commercialBlock;

    public PumpReport(List<Pump> pumpsList, Collection<PumpRequest> pumpRequests) {
        this.pumpsList = pumpsList;
        this.pumpRequests = pumpRequests;
        this.pumpTechResponses = choosePumps();
        this.commercialBlock = new PumpCommercialBlock(this.pumpTechResponses);
    }

    public PumpReport() {
    }

    private List<PumpTechResponse> choosePumps() {
        PumpSelector selector = new PumpSelector();
        return this.pumpRequests.stream().
                map(value -> new PumpTechResponse(value, selector.selectPump(this.pumpsList, value.getConsumption(), value.getPressure())))
                .collect(Collectors.toList());
    }

    public List<Pump> getPumpsList() {
        return pumpsList;
    }

    public void setPumpsList(List<Pump> pumpsList) {
        this.pumpsList = pumpsList;
    }

    public Collection<PumpRequest> getPumpRequests() {
        return pumpRequests;
    }

    public void setPumpRequests(Collection<PumpRequest> pumpRequests) {
        this.pumpRequests = pumpRequests;
    }

    public List<PumpTechResponse> getPumpTechResponses() {
        return pumpTechResponses;
    }

    public void setPumpTechResponses(List<PumpTechResponse> pumpTechResponses) {
        this.pumpTechResponses = pumpTechResponses;
    }

    public PumpCommercialBlock getCommercialBlock() {
        return commercialBlock;
    }

    public void setCommercialBlock(PumpCommercialBlock commercialBlock) {
        this.commercialBlock = commercialBlock;
    }
}
