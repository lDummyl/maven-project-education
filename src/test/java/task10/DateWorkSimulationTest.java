package task10;

import org.junit.Test;
import task8.PumpReport;

import java.util.List;

import static org.junit.Assert.*;

public class DateWorkSimulationTest {
    @Test
    public void workSimulationTest(){
        DateWorkSimulation dateWorkSimulation = new DateWorkSimulation();
        List<PumpReport> simulate = dateWorkSimulation.simulate();

        for (PumpReport pumpReport : simulate) {
            assertNotNull(pumpReport);
            assertTrue(pumpReport.getFailSelected() >= 0);
            assertTrue(pumpReport.getSuccessSelected() > 0);
            assertTrue(pumpReport.getCommercialBlock().getPriceInTotal() > 0);
        }
    }

}