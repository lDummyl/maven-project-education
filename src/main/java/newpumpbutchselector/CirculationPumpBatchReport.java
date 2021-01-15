package newpumpbutchselector;

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

public class CirculationPumpBatchReport {
    private final Collection<CirculationPumpResponse> responses;
    private final CommercialBLock commercialBLock;

    public CirculationPumpBatchReport(Collection<CirculationPumpResponse> responses) {
        this.responses = responses;
        this.commercialBLock = new CommercialBLock(responses);
    }

    public Collection<CirculationPumpResponse> getResponses() {
        return responses;
    }

    public CommercialBLock getCommercialBLock() {
        return commercialBLock;
    }

    public static class CommercialBLock {
        Set<Pump> uniqueModels;
        Integer uniqueModelsNumber;
        Double priceInTotal;
        Double priceWithoutDelivery;
        Double averagePrice;

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
            if (price > 10_000) {
                return price;
            } else {
                return price * 1.1;
            }
        }

        private Double calculatePriceWithoutDelivery(Collection<CirculationPumpResponse> responses) {
            return responses.stream().map(response -> response.getPumpOrNull().getRublePrice()).mapToDouble(Double::doubleValue).sum();
        }

        private Set<Pump> searchUniqueModels(Collection<CirculationPumpResponse> responses) {
            return responses.stream().map(CirculationPumpResponse::getPumpOrNull).filter(Objects::nonNull).collect(Collectors.toSet());
        }

        public Set<Pump> getUniqueModels() {
            return uniqueModels;
        }

        public void setUniqueModels(Set<Pump> uniqueModels) {
            this.uniqueModels = uniqueModels;
        }

        public Integer getUniqueModelsNumber() {
            return uniqueModelsNumber;
        }

        public void setUniqueModelsNumber(Integer uniqueModelsNumber) {
            this.uniqueModelsNumber = uniqueModelsNumber;
        }

        public Double getPriceInTotal() {
            return priceInTotal;
        }

        public void setPriceInTotal(Double priceInTotal) {
            this.priceInTotal = priceInTotal;
        }

        public Double getPriceWithoutDelivery() {
            return priceWithoutDelivery;
        }

        public void setPriceWithoutDelivery(Double priceWithoutDelivery) {
            this.priceWithoutDelivery = priceWithoutDelivery;
        }
    }
}
