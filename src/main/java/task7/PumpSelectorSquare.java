package task7;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PumpSelectorSquare implements PumpSelector {

    private List<PumpIMP> pumps = PumpCharacteristicsLoader.getPumps();

    @Override
    public PumpIMP select(Double pressure, Double flow) {
        pumps.sort(Comparator.comparing(PumpIMP::getPrice));

        return getProfitablePump(pumps, pressure, flow);
    }

    public PumpIMP selectInPriceRange(Double pressure, Double flow, Double minPrice, Double maxPrice) {
        List<PumpIMP> filteredPumps = pumps.stream()
                .filter(i -> i.getPrice() >= minPrice && i.getPrice() <= maxPrice)
                .collect(Collectors.toList());
        filteredPumps.sort(Comparator.comparing(PumpIMP::getPrice));

        return getProfitablePump(filteredPumps, pressure, flow);
    }

    private PumpIMP getProfitablePump(List<PumpIMP> pumpsList, Double pressure, Double flow) {
        PumpIMP suitablePump = null;
        Double previouslyValue = 0.;
        for (PumpIMP pump : pumpsList) {
            Double newValue = pump.calculateConsumption(flow);
            if (newValueIsLess(pressure, newValue, previouslyValue)) {
                suitablePump = pump;
                previouslyValue = newValue;
            }
        }

        return suitablePump;
    }

    private Boolean newValueIsLess(Double pressure, Double comparedValue, Double previouslyValue) {
        if (comparedValue.equals(previouslyValue)) {
            return false;
        } else if (previouslyValue.equals(0.)) {
            return true;
        }

        Double newValue = getModularValue(pressure - comparedValue);
        Double oldValue = getModularValue(pressure - previouslyValue);

        return newValue < oldValue;
    }

    private Double getModularValue(Double value) {
        // TODO: 9/18/19 самый простой
//        return Math.abs(value);
        // TODO: 9/18/19  это с тернарником
        return value < 0 ? value * -1 : value;

//        if (value >= 0) {
//            return value;
//        } else {
//            return (-1 * value);
//        }
    }
}
