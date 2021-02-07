package task7.selector;

import org.junit.Test;
import task7.pump.Pump;
import task8.PumpRequest;

import java.util.Optional;

import static org.junit.Assert.*;

public class PumpSelectorTest {

    @Test
    public void selectPump() throws PumpSelectorException {
        PumpRequest pumpRequest = new PumpRequest(0.8, 0.8);
        PumpSelector pumpSelector = new PumpSelector();
        Optional<Pump> pump = pumpSelector.selectPump(pumpRequest);
        assertTrue(pump.isPresent());
    }
    @Test
    public void selectPumpNoReq() throws PumpSelectorException {
        PumpSelector pumpSelector = new PumpSelector();

        double consumption = 0.8;
        double pressure = 0.8;

        Optional<Pump> pump = pumpSelector.selectPump(consumption, pressure);
        assertTrue(pump.isPresent());
    }

    @Test
    public void selectEmptyPump() throws PumpSelectorException {
        PumpRequest pumpRequest = new PumpRequest(100.0, 100.0);
        PumpSelector pumpSelector = new PumpSelector();
        Optional<Pump> pump = pumpSelector.selectPump(pumpRequest);
        assertFalse(pump.isPresent());
    }

    @Test
    public void addPump() throws PumpSelectorException {
        PumpRequest pumpRequest = new PumpRequest(0.8, 0.8);
        PumpSelector pumpSelector = new PumpSelector();
        Optional<Pump> pump = pumpSelector.selectPump(pumpRequest);
    }

    @Test
    public void exceptionPump() {
        PumpRequest pumpRequest = new PumpRequest(null, 0.8);
        PumpSelector pumpSelector = new PumpSelector();
        try {
            Optional<Pump> pump = pumpSelector.selectPump(pumpRequest);
        } catch (PumpSelectorException e) {
            assertEquals("Null value in request", e.getMessage());
        }

        PumpRequest negativeValue = new PumpRequest(-1.0, 0.8);
        try {
            Optional<Pump> pump = pumpSelector.selectPump(negativeValue);
        } catch (PumpSelectorException e) {
            assertEquals("Negative value in request", e.getMessage());
        }
    }
}