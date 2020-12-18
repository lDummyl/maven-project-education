package task7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class PumpSelectorTest {
    File testFile = new File("PumpTest.json");
    PumpSelector pumpSelector = new PumpSelector(testFile);
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addPumpTest() throws IOException {
        testFile.createNewFile();

        Double[] consumptionModel1 = {5.0, 5.0, 5.0};
        Double[] pressureModel1 = {10.0, 20.0, 30.0};

        Double[] consumptionModel2 = {1.0, 2.0, 3.0};
        Double[] pressureModel2 = {5.0, 10.0, 15.0};

        Pump pump = new Pump("Model 1", consumptionModel1, pressureModel1, 100.0);
        Pump pump1 = new Pump("Model 2", consumptionModel2, pressureModel2, 120.0);

        pumpSelector.addToJson(pump);
        pumpSelector.addToJson(pump1);


        List<Pump> pumps = objectMapper.readValue(testFile, new TypeReference<List<Pump>>() {
        });
        assertNotNull(pumps.get(0));
        assertEquals(pump, pumps.get(0));
        assertNotNull(pumps.get(1));
        assertEquals(pump1, pumps.get(1));
    }
    @Test
    public void selectTest() throws IOException {
        testFile.createNewFile();

        Double[] consumptionModel1 = {5.0, 5.0, 5.0};
        Double[] pressureModel1 = {10.0, 20.0, 30.0};

        Double[] consumptionModel2 = {1.0, 2.0, 3.0};
        Double[] pressureModel2 = {5.0, 10.0, 15.0};

        Double[] consumptionModel3 = {1.0, 2.0, 3.0};
        Double[] pressureModel3 = {1.0, 4.0, 6.0};

        Pump pump = new Pump("Model 1", consumptionModel1, pressureModel1, 100.0);
        Pump pump1 = new Pump("Model 2", consumptionModel2, pressureModel2, 120.0);
        Pump pump2 = new Pump("Model 3", consumptionModel3, pressureModel3, 110.0);

        pumpSelector.addToJson(pump);
        pumpSelector.addToJson(pump1);
        pumpSelector.addToJson(pump2);


    }

}