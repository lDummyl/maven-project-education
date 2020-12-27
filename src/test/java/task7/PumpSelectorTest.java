package task7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class PumpSelectorTest {
    PumpSelector pumpSelector = new PumpSelector();
    @Test
    public void oneSpeedTest() {
        Double[] consumptionModel1 = {1.0, 2.0, 3.0};
        Double[] pressureModel1 = {1.0, 2.0, 3.0};


        Double[] consumptionModel2 = {1.0, 2.0, 3.0};
        Double[] pressureModel2 = {1.0, 2.0, 3.0};


        Double[] consumptionModel3 = {1.0, 2.0, 3.0};
        Double[] pressureModel3 = {1.0, 4.0, 6.0};

        Double[] consumptionModel31 = {1.0, 2.0, 3.0};
        Double[] pressureModel31 = {10.0, 40.0, 60.0};


        Pump pump = new Pump("Model 1", consumptionModel1, pressureModel1, 110.0);
        Pump pump1 = new Pump("Model 2", consumptionModel2, pressureModel2, 120.0);
        Pump pump2 = new Pump("Model 3", consumptionModel3, pressureModel3, 160.0);


        ArrayList<Pump> pumps = new ArrayList<>();
        pump2.addSpeed(consumptionModel31, pressureModel31);

        pumps.add(pump);
        pumps.add(pump1);
        pumps.add(pump2);

        PumpSelector pumpSelector = new PumpSelector();
        Optional<Pump> pump3 = pumpSelector.selectPump(pumps, 20.0, 40.0);


        assertEquals(pump2, pump3.get());
    }

}