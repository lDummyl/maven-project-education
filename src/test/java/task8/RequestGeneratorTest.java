package task8;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RequestGeneratorTest {
    @Test
    public void generateOneRequest() {
        RequestGenerator requestGenerator = new RequestGenerator();
        int numberOfRequests = 1;
        List<PumpRequest> pumpRequests = requestGenerator.generateRequests(numberOfRequests);
        PumpRequest pumpRequest = pumpRequests.get(0);
        assertNotNull(pumpRequest);
        assertTrue(pumpRequest.getConsumption() > 0);
        assertTrue(pumpRequest.getPressure() > 0);
    }

    @Test
    public void generateManyRequest() {
        RequestGenerator requestGenerator = new RequestGenerator();
        int numberOfRequests = 100000;
        List<PumpRequest> pumpRequests = requestGenerator.generateRequests(numberOfRequests);
        assertEquals(pumpRequests.size(), numberOfRequests);
        pumpRequests.forEach(Assert::assertNotNull);
        for (PumpRequest pumpRequest : pumpRequests) {
            assertTrue(pumpRequest.getPressure() >= 1);
            assertTrue(pumpRequest.getConsumption() >=1);
        }
    }

}