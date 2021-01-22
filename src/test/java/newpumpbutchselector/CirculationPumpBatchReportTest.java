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
        CirculationPumpBatchSelector circulationPumpBatchSelector = new CirculationPumpBatchSelector();
        CirculationPumpBatchReport report = circulationPumpBatchSelector.selectPumpsWithReport(requests);

        CommercialBLock commercialBLock = report.getCommercialBLock();
        commercialBLock.getAveragePrice();


    }

}