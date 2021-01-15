package newpumpbutchselector;

import org.junit.Test;
import task8.PumpRequest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CirculationPumpBatchReportTest {
    @Test
    public void reportTest() {
        List<PumpRequest> requests = Arrays.asList(new PumpRequest(1.0, 2.0), new PumpRequest(2.0, 2.0));
        CirculationBatchSelector circulationBatchSelector = new CirculationBatchSelector();
        CirculationPumpBatchReport report = circulationBatchSelector.selectPumpsWithReport(requests);

        Double priceInTotal = report.getCommercialBLock().priceInTotal;
        Double priceWithoutDelivery = report.getCommercialBLock().priceWithoutDelivery;

        assertNotNull(report);
        assertTrue(priceInTotal > 0);
        assertTrue(priceWithoutDelivery > 0);
        assertTrue(priceInTotal > priceWithoutDelivery);
        assertTrue(report.getCommercialBLock().uniqueModels.size() > 0);
        assertFalse(report.getCommercialBLock().uniqueModels.contains(null));
        assertEquals(requests.size(), report.getResponses().size());

    }

}