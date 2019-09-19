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
    // TODO: 9/18/19 да верно, если например взять насос GHNMbasic II 40-70F и параметры 4м\ч и 1м, то по факту на 3й скорости будет 8м\ч. Что в 2 раза больше а значит и скорость
    //  может быть выше допустимной по нормативам или заданным ограничением. Что не допустимо, Ее кстати тоже можно расчитать. у каждого насоса есть даметр, в его сечении можно прикинуть скорость.
    //  характеристика сети параболическая чтобы не возится с этим можно упростить до линейной функции То есть от точки 0 - 0 через расчетную точку нужно построить график до пересечения с
    //  графиком насоса. В пересечении координаты будут соответствовать рабочим параметрам.
    // я не силен в насосах)) не понял что это за соотношение "4м\ч и 1м" и что значит "на 3й скорости будет 8м\ч"))

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
    // TODO: 9/18/19 когда подбор не состоялся возвращать null не очень информативно, лучше кидать эксепшн и в него помещать сообщение о том почему подбор не состоялся.
    //  Заведи свой класс и отнаследуй от RuntimeException.
    public void selectInPriceRangeNullTest() {
        PumpSelectorSquare pumpSelectorSquare = new PumpSelectorSquare();

        PumpIMP selected;
        boolean isSelected = false;

        Double minPrice = 80000.;
        Double maxPrice = 120000.;
        try {
            selected = pumpSelectorSquare.selectInPriceRange(100., 9.5, minPrice, maxPrice);
            isSelected = true;
        } catch (RuntimeNullException ex) {
            isSelected = false;
            log.info(ex.toString());
        }

        assertFalse(isSelected);

        minPrice = 40000.;
        maxPrice = 10000.;
        try {
            selected = pumpSelectorSquare.selectInPriceRange(100., 9.5, minPrice, maxPrice);
            isSelected = true;
        } catch (RuntimeNullException ex) {
            isSelected = false;
            log.info(ex.toString());
        }

        assertFalse(isSelected);
    }
}