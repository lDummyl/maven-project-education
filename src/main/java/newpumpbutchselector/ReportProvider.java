package newpumpbutchselector;

import java.util.Collection;

public class ReportProvider {
    private final CommercialBLockProvider commercialBLockProvider;
    private final Collection<CirculationPumpResponse> responses;


    public ReportProvider(Collection<CirculationPumpResponse> responses) {
        this.responses = responses;
        this.commercialBLockProvider = new CommercialBLockProvider(this.responses);
    }
    public CirculationPumpBatchReport createReport(){
            return new CirculationPumpBatchReport(responses, commercialBLockProvider.createCommercialBlock());
    }

}
