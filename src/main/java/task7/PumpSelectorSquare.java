package task7;

import java.util.ArrayList;
import java.util.List;

public class PumpSelectorSquare implements PumpSelector {

    @Override
    public PumpIMP select(Double pressure, Double flow) {
        /*
        PumpIMP pumpIMP = PumpCharacteristicsLoader.pumps.get(0);
        Double[] functionArgs = pumpIMP.getFunctionArgs();
        Double pumpPressure = functionArgs[0]* flow*flow + functionArgs[1]*flow + functionArgs[2];
        if(pumpPressure > pressure){
            System.out.println("ok");
            return pumpIMP;
        }
        return null;
        */

        List<PumpIMP> pumps = PumpCharacteristicsLoader.getPumps();

        PumpIMP suitablePump = null;
        Double previouslyValue = 0.;
        for (PumpIMP pump : pumps) {
            Double value = pump.calculateConsumption(flow);
            if (compareValues(pressure, value, previouslyValue)) {
                suitablePump = pump;
                previouslyValue = value;
            }
        }

        return suitablePump;
    }

    // TODO: 9/15/19 конвенции именования boolean возвращающих методов лучше соблюдать, они оченть просты, если возврат это ответ да или нет,
    //  то имя метода это вопрос на кторый мы отвечаем.
    private Boolean compareValues(Double pressure, Double comparedValue, Double previouslyValue) {
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
