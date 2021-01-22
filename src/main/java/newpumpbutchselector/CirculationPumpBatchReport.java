package newpumpbutchselector;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;


@Setter
@Getter
@NoArgsConstructor
public class CirculationPumpBatchReport {
    private Collection<CirculationPumpResponse> responses;
    private CommercialBLock commercialBLock;

    public CirculationPumpBatchReport(Collection<CirculationPumpResponse> responses, CommercialBLock commercialBLock) {
        this.responses = responses;
        this.commercialBLock = commercialBLock;
    }

}
