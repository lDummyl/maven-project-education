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
    public PumpIMP select(Double pressure, Double flow) {
        pumps.sort(Comparator.comparing(PumpIMP::getPrice));

        return getProfitablePump(pumps, pressure, flow, ratioPercent);
    }

    public PumpIMP selectInPriceRange(Double pressure, Double flow, Double minPrice, Double maxPrice) {
        List<PumpIMP> filteredPumps = pumps.stream()
                .filter(i -> i.getPrice() >= minPrice && i.getPrice() <= maxPrice)
                .collect(Collectors.toList());
        filteredPumps.sort(Comparator.comparing(PumpIMP::getPrice));

        return getProfitablePump(filteredPumps, pressure, flow, ratioPercent);
    }

    private PumpIMP getProfitablePump(List<PumpIMP> pumpsList, Double pressure, Double flow, Double ratioPercent) {
        PumpIMP suitablePump = null;
        Double previouslyValue = 0.;
        for (PumpIMP pump : pumpsList) {
            Double newValue = pump.calculateConsumption(flow);
            Double workPoint = pump.calculateWorkPoint(pressure, flow);
            if (newValueIsLess(pressure, newValue, previouslyValue) &&
                    ratioPercentIsNormal(ratioPercent, newValue, workPoint)) {
                suitablePump = pump;
                previouslyValue = newValue;
            }
        }

        if (suitablePump == null) {
            throw new PumpNotSelectedException(ErrorMessage.NOT_FOUND); // TODO: 9/19/19 следующим шагом будет поместить отчет о том почему подбор не состоялся. Слишком много/ слишком мало и тд.
        }
        return suitablePump;
    }

    private Boolean newValueIsLess(Double pressure, Double comparedValue, Double previouslyValue) {
        if (comparedValue.equals(previouslyValue)) {
            return false;
        } else if (previouslyValue.equals(0.)) {
            return true;
        }

        Double newValue = Math.abs(pressure - comparedValue);
        Double oldValue = Math.abs(pressure - previouslyValue);

        return newValue < oldValue;
    }

    private Boolean ratioPercentIsNormal(Double ratioPercent, Double newValue, Double workPoint) {
        Double percent = workPoint / newValue * 100;
        return percent > 0 && percent <= ratioPercent;
    }
}
