package task8;

import java.util.Collection;
import java.util.Set;

/* второй блок коммерческий, список уникальных моделей, их количество цена за штуку/сумму
        плюс всего за предложение, с доставкой(отдельно) 10% от стоимости, при стоиомсти выше 10 000
        доставка бесплатно.*/
// FIXME: 1/5/2021 Пока не разобрался с требованиями
public class PumpCommercialBlock {
    Set<ChosenPump> chosenPumpsUniq;
    Integer numberOfUniqModel;
    public PumpCommercialBlock(Collection<ChosenPump> chosenPumps) {
        //Double aDouble = chosenPumps.stream().map(value -> value.getPump().getRublePrice()).max().get();

    }
}
