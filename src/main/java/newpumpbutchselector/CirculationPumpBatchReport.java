package newpumpbutchselector;

import lombok.Getter;
import lombok.Setter;
import task7.Pump;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
/*
	Реализовать пакетный подбор насосов
	создать генератор Json, который содержит пары расход/напор
	принимать его на вход и выдавать json в виде отчета: насос, входные параметры,
	рабочая точка модель, первый технический блок
	второй блок коммерческий, список уникальных моделей, их количество цена за штуку/сумму
	плюс всего за предложение, с доставкой(отдельно) 10% от стоимости, при стоиомсти выше 10 000
	доставка бесплатно.
 */

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


    @Getter
    @Setter
    public static class CommercialBLock {
        Set<Pump> uniqueModels;
        Integer uniqueModelsNumber;
        Double priceInTotal;
        Double priceWithoutDelivery;
        Double averagePrice;
        private Double priceToCoastLosDelivery = 100_000.0;

        public CommercialBLock(Collection<CirculationPumpResponse> responses) {
            this.uniqueModels = searchUniqueModels(responses);
            this.uniqueModelsNumber = uniqueModels.size();
            this.priceWithoutDelivery = calculatePriceWithoutDelivery(responses);
            this.priceInTotal = calculatePriceInTotal(priceWithoutDelivery);
            this.averagePrice = calculateAveragePrice(responses);
        }

        private Double calculateAveragePrice(Collection<CirculationPumpResponse> responses) {
            return priceInTotal/ responses.size();
        }

        private Double calculatePriceInTotal(Double price) {
            if (price > priceToCoastLosDelivery) {
                return price;
            } else {
                return price * 1.1;
            }
        }

        private Double calculatePriceWithoutDelivery(Collection<CirculationPumpResponse> responses) {
            double sum = responses.stream().map(CirculationPumpResponse::getPumpOrNull).filter(Objects::nonNull).map(value -> value.getPrice().getRublePrice()).mapToDouble(Double::doubleValue).sum();
            return sum;

        }

        private Set<Pump> searchUniqueModels(Collection<CirculationPumpResponse> responses) {
            return responses.stream().map(CirculationPumpResponse::getPumpOrNull).filter(Objects::nonNull).collect(Collectors.toSet());
        }
    }
}
