package newpumpselector;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Test;
import task7.Pump;
import task7.PumpCollector;
import task7.Speed;

import java.io.File;
import java.util.*;

import static org.junit.Assert.*;

public class CirculationPumpSelectorTest {
    ObjectMapper mapper = new ObjectMapper();
    File notChangedTestFileWithPumps = new File("src/test/resources/pumpjsons/TestFileWithPumpsOnlyRead.json");

    @SneakyThrows
    @Test
    public void selectionTest() throws CirculationPumpSelectorException {

        Double consumption = 0.22;
        Double pressure = 2.7;
        CirculationPumpSelector circulationPumpSelector = new CirculationPumpSelector();

        Optional<Pump> pump = circulationPumpSelector.selectPump(consumption, pressure);
        assertTrue(pump.isPresent());

    }
    @SneakyThrows
    @Test
    public void selectionRightPumpTest() throws CirculationPumpSelectorException {

        PumpCollector pumpCollector = new PumpCollector();
        Set<Pump> pumpsThatWeHave = pumpCollector.deserializePumpJson();
        ArrayList<Pump> pumpsValid = new ArrayList<>(pumpsThatWeHave);

        Collections.sort(pumpsValid);
        Pump neededPump = pumpsValid.get(0);
        Speed speed = neededPump.getSpeeds().get(0);

        Double pressure = speed.getPressure()[1];
        Double consumption = speed.getConsumption()[1];

        CirculationPumpSelector circulationPumpSelector = new CirculationPumpSelector();

        Optional<Pump> pump = circulationPumpSelector.selectPump(consumption, pressure);
        assertTrue(pump.isPresent());
        assertEquals(neededPump ,pump.get());

    }

    @Test
    public void notValidRequestTestNull() {
        Double consumption = null;
        Double pressure = 2.7;
        CirculationPumpSelector circulationPumpSelector = new CirculationPumpSelector();

        Optional<Pump> pump = null;
        try {
            pump = circulationPumpSelector.selectPump(consumption, pressure);
        } catch (CirculationPumpSelectorException e) {
            assertEquals("Null value in request", e.getMessage());
        }
    }

    @Test
    public void notValidRequestTestNegativeValue() {
        Double consumption = -5.0;
        Double pressure = 2.7;
        CirculationPumpSelector circulationPumpSelector = new CirculationPumpSelector();

        Optional<Pump> pump = null;
        try {
            pump = circulationPumpSelector.selectPump(consumption, pressure);
        } catch (CirculationPumpSelectorException e) {
            assertEquals("Negative value in request", e.getMessage());
        }
    }

}