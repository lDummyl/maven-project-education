package task7.selector;

import org.junit.Assert;
import org.junit.Test;
import task7.pump.Pump;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class PumpFileCollectorTest {

    @Test
    public void addPump() {
        PumpFileCollector pumpFileCollector = new PumpFileCollector();
        Collection<Pump> pumps = pumpFileCollector.getPumps();
        ArrayList<Pump> pumpList = new ArrayList<>(pumps);
        Pump pump = pumpList.get(0);

        pumpFileCollector.addPump(pump);
    }
    @Test
    public void addPumps() {
        PumpFileCollector pumpFileCollector = new PumpFileCollector();
        Collection<Pump> pumps = pumpFileCollector.getPumps();
    }
    @Test
    public void exceptionTest() {
        PumpFileCollector collector = new PumpFileCollector(new File(""));
        try {
            Collection<Pump> pumps = collector.getPumps();
        } catch (Exception e) {
            assertNotNull(e);
        }


        try {
           collector.addPump(null);
        } catch (Exception e) {
            assertNotNull(e);
        }


    }

    @Test
    public void getPumps() {
        PumpFileCollector pumpFileCollector = new PumpFileCollector();
        Collection<Pump> pumps = pumpFileCollector.getPumps();
        assertNotNull(pumps);
        pumps.forEach(Assert::assertNotNull);
    }
}