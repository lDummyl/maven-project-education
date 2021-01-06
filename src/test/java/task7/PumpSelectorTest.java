package task7;

import org.junit.Test;
import task8.CollectionPump;
import task8.PumpRequest;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class PumpSelectorTest {
    @Test
    public void selectorOneRequestTest() {
        PumpSelector pumpSelector = new PumpSelector();
        PumpRequest pumpRequest = new PumpRequest(0.24, 5.0);

        List<Pump> pumps = CollectionPump.addPumps();
        Collections.sort(pumps);

        Optional<Pump> pump = pumpSelector.selectPump(pumpRequest);
        assertTrue(pump.isPresent());
        assertEquals(pumps.get(0), pump.get());
    }
    @Test
    public void selectorNoRealPumpTest() {
        PumpSelector pumpSelector = new PumpSelector();
        PumpRequest pumpRequest = new PumpRequest(4.0, 500.0);

        List<Pump> pumps = CollectionPump.addPumps();
        Collections.sort(pumps);

        Optional<Pump> pump = pumpSelector.selectPump(pumpRequest);
        assertFalse(pump.isPresent());

    }



}