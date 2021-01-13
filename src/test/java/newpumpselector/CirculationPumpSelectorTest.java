package newpumpselector;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Test;
import task7.Pump;

import java.io.File;
import java.util.List;
import java.util.Optional;

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

}