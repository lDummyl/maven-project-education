package task7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class PumpCollectorTest {
    File testFile = new File("PumpTest.json");
    PumpCollector pumpCollector = new PumpCollector(testFile);
    ObjectMapper objectMapper = new ObjectMapper();
/*
    @Test
    public void treeSpeedPump() throws IOException {
        testFile.createNewFile();

        Double[] consumption1 = {5.0, 5.0, 5.0};
        Double[] pressure1 = {10.0, 20.0, 30.0};

        Double[] consumption2 = {1.0, 2.0, 3.0};
        Double[] pressure2 = {5.0, 10.0, 15.0};

        Double[] consumption3 = {1.0, 2.0, 3.0};
        Double[] pressure3 = {1.0, 4.0, 6.0};

        Pump pump = new Pump("Model 3speed", consumption1, pressure1, 150.0);
        pump.addSpeed(consumption2, pressure2);
        pump.addSpeed(consumption3, pressure3);
        pumpCollector.addToJson(pump);
        testFile.delete();
    }*/


    @Test
    public void addPumpTest() throws IOException {
        testFile.createNewFile();

        Double[] consumptionModel1 = {5.0, 5.0, 5.0};
        Double[] pressureModel1 = {10.0, 20.0, 30.0};

        Double[] consumptionModel2 = {1.0, 2.0, 3.0};
        Double[] pressureModel2 = {5.0, 10.0, 15.0};

        Pump pump = new Pump("Model 1", consumptionModel1, pressureModel1, 100.0);
        Pump pump1 = new Pump("Model 2", consumptionModel2, pressureModel2, 120.0);
        pump.addSpeed(consumptionModel2,pressureModel2);

        pumpCollector.addToJson(pump);



        List<Pump> pumps = objectMapper.readValue(testFile, new TypeReference<List<Pump>>() {
        });
        assertNotNull(pumps.get(0));
        assertEquals(pump, pumps.get(0));
        assertNotNull(pumps.get(1));
        assertEquals(pump1, pumps.get(1));
    }
    /*@Test
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

        pumpCollector.addToJson(pump);
        pumpCollector.addToJson(pump1);
        pumpCollector.addToJson(pump2);
    }*/

}