package task8;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import task7.Pump;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Setter
@Getter
@NoArgsConstructor
public class PumpCommercialBlock {
    private Set<Pump> uniquePumps;
    private Integer numberOFUniqModels;
    private Double priceInTotal;
    private Double priceWithDelivery;

    public PumpCommercialBlock(Collection<PumpTechResponse> pumpTechResponse) {
        this.uniquePumps = getUniModels(pumpTechResponse);
        this.numberOFUniqModels = uniquePumps.size();
        this.priceInTotal = getTotalPrice(pumpTechResponse);
        this.priceWithDelivery = calculatePriceWithDelivery();
    }

    private Double calculatePriceWithDelivery() {
        if (this.priceInTotal > 10_000.0) {
            return this.priceInTotal;
        } else {
            return priceInTotal * 1.1;
        }
    }

    private Double getTotalPrice(Collection<PumpTechResponse> pumpTechResponse) {
        Double sum = 0.0;
        for (PumpTechResponse techResponse : pumpTechResponse) {
            if (techResponse.getPumpOrNull() != null) {
                sum += techResponse.getPumpOrNull().getPrice().getRublePrice();
            }
        }
        return sum;
    }

    private Set<Pump> getUniModels(Collection<PumpTechResponse> pumpTechResponse) {
        return pumpTechResponse.stream().map(PumpTechResponse::getPumpOrNull).filter(value -> value!=null).collect(Collectors.toSet());
    }
}
