package task7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class PumpCollectorTest {
    File testFile = new File("PumpTest.json");
    PumpCollector pumpCollector = new PumpCollector(testFile);
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void treeSpeedPump() throws IOException {
        testFile.delete();
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

        Set<Pump> pumps = pumpCollector.deserializePumpJson();
        /*Pump deserializedPump = pumps.get(0);
        assertEquals(pump, deserializedPump);
        testFile.delete();*/
    }


    @Test
    public void addPumpTest() throws IOException {
        testFile.delete();
        testFile.createNewFile();

        Double[] consumptionModel1 = {5.0, 5.0, 5.0};
        Double[] pressureModel1 = {10.0, 20.0, 30.0};

        Double[] consumptionModel2 = {1.0, 2.0, 3.0};
        Double[] pressureModel2 = {5.0, 10.0, 15.0};

        Pump model1 = new Pump("Model 1", consumptionModel1, pressureModel1, 100.0);
        Pump model2 = new Pump("Model 2", consumptionModel2, pressureModel2, 120.0);

        ArrayList<Pump> pumpsTestList = new ArrayList<>();
        pumpsTestList.add(model1);
        pumpsTestList.add(model2);

        pumpCollector.addToJson(pumpsTestList);
        List<Pump> pumps = objectMapper.readValue(testFile, new TypeReference<List<Pump>>() {
        });
        Collections.sort(pumps);
        Collections.sort(pumpsTestList);

        assertEquals(pumps, pumpsTestList);
        System.out.println();
        testFile.delete();
    }

    @Test
    public void addPumpTestFull() throws IOException {
        PumpSelectionApp pumpSelectionApp = new PumpSelectionApp(new File("PumpTestFull.json"));
        Optional<Pump> pumpOptional = pumpSelectionApp.selectPump(5.0, 10.0);

        assertEquals("Model 1", pumpOptional.get().getModel());
    }

    @Test
    public void addPumpTestOverflow() throws IOException {
        PumpSelectionApp pumpSelectionApp = new PumpSelectionApp(new File("PumpTestFull.json"));
        Optional<Pump> pumpOptional = pumpSelectionApp.selectPump(20000.0, 10.0);

        assertEquals("Model 1", pumpOptional.get().getModel());
    }


    public void testRuntime() {
        System.out.println();
        try {
            testChecked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  testUnchecked();

    }

    public void testChecked() throws IOException {
        throw new IOException();
    }

    public void testUnchecked() throws OutOfMemoryError {
        throw new OutOfMemoryError();
    }
}

