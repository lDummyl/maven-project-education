package task7;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class PumpSelectorSquareTest {

    Logger log = Logger.getLogger(PumpSelectorSquare.class.getName());

    @Test
    public void selectTest() {
        PumpSelectorSquare pumpSelectorSquare = new PumpSelectorSquare();
        PumpIMP select = pumpSelectorSquare.select(2., 5.);
        log.info(select.getName());
        assertEquals("NMT MINI PRO", select.getName());
    }

    // TODO: 9/17/19  ну и кейсы, штук 5, что если ты передашь очень большие параметры или микроскопические. Нужно пройти все пограничные случаи
    //  и добавь соотношение расхода расчетного к фактическому и поведение если это соотношение больше чем задаваемый процент.
}