package newpumpbutchselector;

import lombok.Getter;
import lombok.Setter;
import task7.Pump;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
public class CirculationPumpBatchReport {
    private final Collection<CirculationPumpResponse> responses;
    private final CommercialBLock commercialBLock;
    private final double priceToCoastLosDelivery;

    public CirculationPumpBatchReport(Collection<CirculationPumpResponse> responses) {
        this.responses = responses;
        this.priceToCoastLosDelivery = 10_000.0;
        this.commercialBLock = new CommercialBLock(responses);
    }

}
