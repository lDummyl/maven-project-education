package task7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import task1.Person;
import task1.PersonsProvider;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.TreeSet;

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
        pump.addSpeed(consumptionModel2, pressureModel2);

        pumpCollector.addToJson(pump);
        pumpCollector.addToJson(pump1);

        List<Pump> o = objectMapper.readValue(testFile, new TypeReference<List<Pump>>() {
        });
        System.out.println();
         /*
        assertNotNull(pumps.get(0));
        assertEquals(pump, pumps.get(0));
        assertNotNull(pumps.get(1));
        assertEquals(pump1, pumps.get(1));*/
    }
    @Test
    public void addPumpTestFull() throws IOException {
        PumpSelectionApp pumpSelectionApp = new PumpSelectionApp("PumpTestFull.json");
        Optional<Pump> pumpOptional = pumpSelectionApp.selectPump(5.0, 10.0);

        assertEquals("Model 1", pumpOptional.get().getModel());

    }
    @Test
    public void addPumpTestOverflow() throws IOException {
        PumpSelectionApp pumpSelectionApp = new PumpSelectionApp("PumpTestFull.json");
        Optional<Pump> pumpOptional = pumpSelectionApp.selectPump(20000.0, 10.0);

        assertEquals("Model 1", pumpOptional.get().getModel());

    }
    @Test
    public void deserializeTwo() throws IOException {
        List<Pump> pumps = objectMapper.readValue(new File("TwoPumps.json"), new TypeReference<List<Pump>>() {
        });
        System.out.println("");
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
    @Test
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

    @Test
    public void bank() {
        int amountOfMoney = 1_000_000;
        int checkedSumm = 80000;


        PersonsProvider personsProvider = new PersonsProvider();
        TreeSet<Person> people = personsProvider.generatePersons(100);
        Random random = new Random();
        for (Person person : people) {
            if (random.nextInt(100)<10){
                checkInCurrentState("Russia");
            }
                transactionCheck(person);
            System.out.println("Вы перевели миллион долларов");
        }
    }

    private void transactionCheck(Person person) {

        try {
            checkPerson(person);
        } catch (Exception e) {
            System.out.println(person.birthDate);
            System.out.println(person.name);
        }
    }

    private void checkPerson(Person person) {

        checkIllegalActivity();
    }

    private void checkIllegalActivity() {
        Random random = new Random();
        String country = "USA";
        if (random.nextInt(100) < 10) {
            country = "Russia";
        }
        checkInCurrentState(country);
    }

    private void checkInCurrentState(String currentState) throws IllegalArgumentException {

        if (currentState.equals("Russia")) {
            throw new IllegalArgumentException();
        }
    }

}