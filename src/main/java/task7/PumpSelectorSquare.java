package task7;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PumpSelectorSquare implements PumpSelector {

    @Override
    public PumpIMP select(Double pressure, Double flow) {
        List<PumpIMP> pumps = PumpCharacteristicsLoader.getPumps().stream()
                .sorted(Comparator.comparing(PumpIMP::getPrice))
                .collect(Collectors.toList());

        PumpIMP suitablePump = null;
        Double previouslyValue = 0.;
        for (PumpIMP pump : pumps) {
            Double newValue = pump.calculateConsumption(flow);
            if (newValueIsLess(pressure, newValue, previouslyValue)) { // тут не пойму как опираться на цену, мне кажется что и без цены все необходимые данные есть
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
