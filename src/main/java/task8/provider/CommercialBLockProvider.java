package task8.provider;

import task7.pump.Pump;
import task8.report.PumpResponse;
import task8.report.CommercialBLock;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class CommercialBLockProvider {
    private final Collection<PumpResponse> responses;

    public CommercialBLockProvider(Collection<PumpResponse> responses) {
        this.responses = responses;
    }

    public CommercialBLock createCommercialBlock() {
        CommercialBLock commercialBLock = new CommercialBLock();

        Double priceWithoutDelivery = calculatePriceWithoutDelivery(responses);
        commercialBLock.setPriceWithoutDelivery(calculatePriceWithoutDelivery(responses));

        Double priceInTotal = calculatePriceInTotal(priceWithoutDelivery);
        commercialBLock.setPriceInTotal(priceInTotal);

        commercialBLock.setAveragePrice(calculateAveragePrice(responses, priceInTotal));

        Set<Pump> uniqueModels = searchUniqueModels(responses);
        commercialBLock.setUniqueModels(uniqueModels);

        commercialBLock.setUniqueModelsNumber(uniqueModels.size());

        return commercialBLock;
    }

    private Double calculateAveragePrice(Collection<PumpResponse> responses, Double priceInTotal) {
        return priceInTotal / responses.size();
    }

    private Double calculatePriceInTotal(Double price) {
        Double priceToCoastLosDelivery = 1000_000.0;
        if (price > priceToCoastLosDelivery) {
            return price;
        } else {
            return price * 1.1;
        }
    }

    private Double calculatePriceWithoutDelivery(Collection<PumpResponse> responses) {
        return responses.stream().filter(value -> value.getPump().isPresent()).map(value -> value.getPump().get())
                .map(value -> value.getPrice().getRublePrice())
                .mapToDouble(Double::doubleValue).sum();

    }

    private Set<Pump> searchUniqueModels(Collection<PumpResponse> responses) {
        return responses.stream().filter(value -> value.getPump().isPresent()).map(value -> value.getPump().get()).collect(Collectors.toSet());
    }
}
