package task8.provider;

import task8.report.PumpBatchReport;
import task8.report.PumpResponse;

import java.util.Collection;

public class ReportProvider {
    private final CommercialBLockProvider commercialBLockProvider;
    private final Collection<PumpResponse> responses;


    public ReportProvider(Collection<PumpResponse> responses) {
        this.responses = responses;
        this.commercialBLockProvider = new CommercialBLockProvider(this.responses);
    }
    public PumpBatchReport createReport(){
            return new PumpBatchReport(responses, commercialBLockProvider.createCommercialBlock());
    }

}
