package newpumpbutchselector;

import org.junit.Test;
import task8.PumpRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
/*
	Реализовать пакетный подбор насосов
	создать генератор Json, который содержит пары расход/напор
	принимать его на вход и выдавать json в виде отчета: насос, входные параметры,
	рабочая точка модель, первый технический блок
	второй блок коммерческий, список уникальных моделей, их количество цена за штуку/сумму
	плюс всего за предложение, с доставкой(отдельно) 10% от стоимости, при стоиомсти выше 10 000
	доставка бесплатно.
 */
public class CirculationPumpButchSelectorTest {
    @Test
    public void generalTest(){
        CirculationPumpButchSelector selector = new CirculationPumpButchSelector();
        List<PumpRequest> requests = Arrays.asList(new PumpRequest(1.0, 2.0), new PumpRequest(2.0, 2.0));

        Collection<CirculationPumpResponse> circulationPumpResponses = selector.selectPumps(requests);
        assertEquals(requests.size(), circulationPumpResponses.size());
    }

}