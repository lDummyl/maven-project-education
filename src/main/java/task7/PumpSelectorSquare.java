package task7;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PumpSelectorSquare implements PumpSelector {

    @Override
    public PumpIMP select(Double pressure, Double flow) {
        List<PumpIMP> pumps = PumpCharacteristicsLoader.getPumps();

        // TODO: 9/16/19 ты не можешь гарантировать что насосы по производительности будут в том же порядке что и по цене,
        //  если задача подобрать самый дешевый из подходящих, такой подход самый простой.
        pumps.sort(Comparator.comparing(PumpIMP::getPrice));

        return calculateConsumption(pumps, pressure, flow);
    }

    public PumpIMP selectInPriceRange(Double pressure, Double flow, Double minPrice, Double maxPrice) {
        List<PumpIMP> pumps = PumpCharacteristicsLoader.getPumps().stream()
                .filter(i -> i.getPrice() >= minPrice && i.getPrice() <= maxPrice)
                .collect(Collectors.toList());
        pumps.sort(Comparator.comparing(PumpIMP::getPrice));

        return calculateConsumption(pumps, pressure, flow);
    }

    private PumpIMP calculateConsumption(List<PumpIMP> pumps, Double pressure, Double flow) {
        PumpIMP suitablePump = null;
        Double previouslyValue = 0.;

        for (PumpIMP pump : pumps) {
            Double newValue = pump.calculateConsumption(flow);
            if (newValueIsLess(pressure, newValue, previouslyValue)) {
                suitablePump = pump;
                previouslyValue = newValue;
            }
        }

        return suitablePump;
    }

    // TODO: 9/15/19 конвенции именования boolean возвращающих методов лучше соблюдать, они оченть просты, если возврат это ответ да или нет,
    //  то имя метода это вопрос на кторый мы отвечаем.
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
        if (value >= 0) {
            return value;
        } else {
            return (-1 * value);
        }
    }
}
