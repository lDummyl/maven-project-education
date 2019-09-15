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
}