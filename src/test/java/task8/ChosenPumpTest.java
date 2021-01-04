package task8;

import org.junit.Test;
import task7.Pump;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ChosenPumpTest {
    @Test
    public void technicalPartTestLowPrice(){
        double consumption = 1.5;
        double pressure = 50.0;
        PumpRequest pumpRequest = new PumpRequest(consumption, pressure);
        List<Pump> pumps = CollectionPump.addPumps();
        Collections.sort(pumps);
        ChosenPump chosenPump = new ChosenPump(pumpRequest, pumps);
        assertNotNull(chosenPump);
        assertEquals(chosenPump.getPump(), pumps.get(0));
    }
    @Test
    public void technicalPartTestHochPrice(){
        double consumption = 65.0;
        double pressure = 1700.0;
        PumpRequest pumpRequest = new PumpRequest(consumption, pressure);
        List<Pump> pumps = CollectionPump.addPumps();
        Collections.sort(pumps);
        ChosenPump chosenPump = new ChosenPump(pumpRequest, pumps);
        assertNotNull(chosenPump);
        assertEquals(chosenPump.getPump(), pumps.get(pumps.size()-2));
    }

}