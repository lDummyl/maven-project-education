package task8.report;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;


@Setter
@Getter
@NoArgsConstructor
public class PumpBatchReport {
    private Collection<PumpResponse> responses;
    private CommercialBLock commercialBLock;

    public PumpBatchReport(Collection<PumpResponse> responses, CommercialBLock commercialBLock) {
        this.responses = responses;
        this.commercialBLock = commercialBLock;
    }
}
