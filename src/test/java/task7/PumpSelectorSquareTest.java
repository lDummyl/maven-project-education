package task7;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class PumpSelectorSquareTest {

    Logger log = Logger.getLogger(PumpSelectorSquare.class.getName());

    @Test
    public void selectTest() {
        PumpSelectorSquare pumpSelectorSquare = new PumpSelectorSquare();
        PumpIMP select = pumpSelectorSquare.select(2., 5.);
        log.info(select.getName());
        assertEquals("NMTD SMART", select.getName());

        select = pumpSelectorSquare.select(272., 5.);
        assertEquals("GHN SOL", select.getName());

        select = pumpSelectorSquare.select(272.5, 5.);
        assertEquals("CL 4 POLES", select.getName());
    }

    // TODO: 9/17/19  ну и кейсы, штук 5, что если ты передашь очень большие параметры или микроскопические. Нужно пройти все пограничные случаи
    //  и добавь соотношение расхода расчетного к фактическому и поведение если это соотношение больше чем задаваемый процент.
    // немного не понял. соотношение расхода расчетного к фактическому реализовать в тот момент когда мы подбираем насосы?

    @Test
    public void selectInPriceRangeTest() {
        PumpSelectorSquare pumpSelectorSquare = new PumpSelectorSquare();

        Double minPrice = 20000.;
        Double maxPrice = 34000.;
        PumpIMP selected = pumpSelectorSquare.selectInPriceRange(3300., 14., minPrice, maxPrice);

        Double pumpPrice = selected.getPrice();
        assertTrue(pumpPrice >= minPrice);
        assertTrue(pumpPrice <= maxPrice);
    }

    @Test
    public void selectInPriceRangeNullTest() {
        PumpSelectorSquare pumpSelectorSquare = new PumpSelectorSquare();

        Double minPrice = 80000.;
        Double maxPrice = 120000.;
        PumpIMP selected = pumpSelectorSquare.selectInPriceRange(100., 9.5, minPrice, maxPrice);

        assertNull(selected);

        minPrice = 40000.;
        maxPrice = 10000.;
        selected = pumpSelectorSquare.selectInPriceRange(100., 9.5, minPrice, maxPrice);

        assertNull(selected);
    }
}