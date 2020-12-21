package task7;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PumpSelectorTest {
    PumpSelector pumpSelector = new PumpSelector();
    @Test
    public void oneSpeedTest(){
        Double[] consumptionModel1 = {5.0, 5.0, 5.0};
        Double[] pressureModel1 = {10.0, 20.0, 30.0};


        Double[] consumptionModel2 = {1.0, 3.0, 3.0};
        Double[] pressureModel2 = {5.0, 10.0, 15.0};


        Double[] consumptionModel3 = {1.0, 2.0, 3.0};
        Double[] pressureModel3 = {1.0, 4.0, 6.0};

        Double[] consumptionModel31 = {10.0, 20.0, 30.0};
        Double[] pressureModel31 = {10.0, 40.0, 60.0};


        Pump pump = new Pump("Model 1", consumptionModel1, pressureModel1, 120.0);
        Pump pump1 = new Pump("Model 2", consumptionModel2, pressureModel2, 120.0);
        Pump pump2 = new Pump("Model 3", consumptionModel3, pressureModel3, 110.0);



        ArrayList<Pump> pumps = new ArrayList<>();
        pump2.addSpeed(consumptionModel31, pressureModel31);


        pumps.add(pump);
        pumps.add(pump1);
        pumps.add(pump2);

        Pump pump3 = pumpSelector.selectPump(pumps, 2.0, 4.0);
        assertEquals(pump3, pump2);
    }

}