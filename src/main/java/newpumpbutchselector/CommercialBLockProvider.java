package newpumpbutchselector;

import task7.Pump;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class CommercialBLockProvider {
    private Collection<CirculationPumpResponse> responses;
    private final Double priceToCoastLosDelivery = 100_000.0;

    public CommercialBLock createCommercialBlock() {
        CommercialBLock commercialBLock = new CommercialBLock();

        Double priceWithoutDelivery = calculatePriceWithoutDelivery(responses);
        commercialBLock.setPriceWithoutDelivery(priceWithoutDelivery);

        Double priceInTotal = calculatePriceInTotal(priceWithoutDelivery);
        commercialBLock.setPriceInTotal(priceInTotal);

        commercialBLock.setAveragePrice(calculateAveragePrice(responses, priceInTotal));

        Set<Pump> uniqueModels = searchUniqueModels(responses);
        commercialBLock.setUniqueModels(uniqueModels);

        commercialBLock.setUniqueModelsNumber(uniqueModels.size());

        return commercialBLock;
    }

    private Double calculateAveragePrice(Collection<CirculationPumpResponse> responses, Double priceInTotal) {
        return priceInTotal / responses.size();
    }

    private Double calculatePriceInTotal(Double price) {
        if (price > priceToCoastLosDelivery) {
            return price;
        } else {
            return price * 1.1;
        }
    }

    private Double calculatePriceWithoutDelivery(Collection<CirculationPumpResponse> responses) {
        return responses.stream().filter(value -> value.getPump().isPresent()).map(value -> value.getPump().get())
                .map(value -> value.getPrice().getRublePrice())
                .mapToDouble(Double::doubleValue).sum();

    }

    private Set<Pump> searchUniqueModels(Collection<CirculationPumpResponse> responses) {
        return responses.stream().filter(value -> value.getPump().isPresent()).map(value -> value.getPump().get()).collect(Collectors.toSet());
    }
}
