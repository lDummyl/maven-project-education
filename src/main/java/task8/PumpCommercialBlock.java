package task8;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import task7.Pump;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@JsonAutoDetect
public class PumpCommercialBlock {
    Set<Pump> uniquePumps;
    Integer numberOFUniqModels;
    Double priceInTotal;
    Double priceWithDelivery;

    public PumpCommercialBlock(Collection<PumpTechResponse> pumpTechResponse) {
        this.uniquePumps = getUniModels(pumpTechResponse);
        this.numberOFUniqModels = uniquePumps.size();
        this.priceInTotal = getTotalPrice(pumpTechResponse);
        this.priceWithDelivery = getPriceWithDelivery();
    }

    private Double getPriceWithDelivery() {
        if (this.priceInTotal > 10_000) {
            return this.priceInTotal;
        } else {
            return priceInTotal * 1.1;
        }
    }

    private Double getTotalPrice(Collection<PumpTechResponse> pumpTechResponse) {
        Double sum = 0.0;
        for (PumpTechResponse techResponse : pumpTechResponse) {
            if (techResponse.getPumpOrNull() != null) {
                sum += techResponse.getPumpOrNull().getRublePrice();
            }
        }
        return sum;
    }

    private Set<Pump> getUniModels(Collection<PumpTechResponse> pumpTechResponse) {
        return pumpTechResponse.stream().map(PumpTechResponse::getPumpOrNull).collect(Collectors.toSet());
    }

    public PumpCommercialBlock() {
    }

    public Set<Pump> getUniquePumps() {
        return uniquePumps;
    }

    public void setUniquePumps(Set<Pump> uniquePumps) {
        this.uniquePumps = uniquePumps;
    }

    public Integer getNumberOFUniqModels() {
        return numberOFUniqModels;
    }

    public void setNumberOFUniqModels(Integer numberOFUniqModels) {
        this.numberOFUniqModels = numberOFUniqModels;
    }

    public Double getPriceInTotal() {
        return priceInTotal;
    }

    public void setPriceInTotal(Double priceInTotal) {
        this.priceInTotal = priceInTotal;
    }

    public void setPriceWithDelivery(Double priceWithDelivery) {
        this.priceWithDelivery = priceWithDelivery;
    }
}
