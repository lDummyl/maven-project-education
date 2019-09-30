package task7;

import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class PumpSelectorSquare implements PumpSelector {

    private List<PumpIMP> pumps = PumpCharacteristicsLoader.getPumps();
    private Double ratioPercent = 10.;

    public PumpSelectorSquare(Double ratioPercent) {
        this.ratioPercent = ratioPercent;
    }

    @Override
    public PumpIMP select(Double flow, Double pressure) {
        pumps.sort(Comparator.comparing(PumpIMP::getPrice));

        return getProfitablePump(pumps, flow, pressure);
    }

    public PumpIMP selectInPriceRange(Double flow, Double pressure, Double minPrice, Double maxPrice) {
        List<PumpIMP> filteredPumps = pumps.stream()
                .filter(i -> i.getPrice() >= minPrice && i.getPrice() <= maxPrice)
                .collect(Collectors.toList());
        filteredPumps.sort(Comparator.comparing(PumpIMP::getPrice));

        return getProfitablePump(filteredPumps, flow, pressure);
    }

    private PumpIMP getProfitablePump(List<PumpIMP> pumpsList, Double flow, Double pressure) {
        for (PumpIMP pump : pumpsList) {
            Double workPoint = pump.calculateWorkPoint(flow, pressure);
            if (workPoint < flow && ratioPercentIsNormal(flow, workPoint)) {
                return pump;
            }
        }

        throw new PumpNotSelectedException(ErrorMessage.NOT_FOUND); // TODO: 9/19/19 следующим шагом будет поместить отчет о том почему подбор не состоялся. Слишком много/ слишком мало и тд.
    }

    private Boolean ratioPercentIsNormal(Double flow, Double workPoint) {
        Double percent = workPoint / flow * 100;
        return percent > 0 && percent <= ratioPercent;
    }
}
