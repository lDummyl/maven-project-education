package task8;


import task7.Pump;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


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
                sum += techResponse.getPumpOrNull().getRublePrice();
            }
        }
        return sum;
    }

    private Set<Pump> getUniModels(Collection<PumpTechResponse> pumpTechResponse) {
        return pumpTechResponse.stream().map(PumpTechResponse::getPumpOrNull).filter(value -> value!=null).collect(Collectors.toSet());
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

    public Double getPriceWithDelivery() {
        return priceWithDelivery;
    }

    public void setPriceWithDelivery(Double priceWithDelivery) {
        this.priceWithDelivery = priceWithDelivery;
    }
}
