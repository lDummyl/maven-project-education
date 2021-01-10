package task10;

import org.junit.Test;
import task8.PumpRequest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class DatePumpRequestGeneratorTest {
    @Test
    public void generationTest(){
        DatePumpRequestGenerator generator = new DatePumpRequestGenerator();
        List<List<PumpRequest>> lists = generator.generateRequests();

        for (List<PumpRequest> list : lists) {
            for (PumpRequest pumpRequest : list) {
                assertNotNull(pumpRequest.getDateTime());
                assertNotNull(pumpRequest.getPressure());
                assertNotNull(pumpRequest.getConsumption());
            }
        }
    }
    @Test
    public void generationElementTest(){
        DatePumpRequestGenerator generator = new DatePumpRequestGenerator();
        List<List<PumpRequest>> lists = generator.generateRequests();
        PumpRequest pumpRequest = lists.get(0).get(0);

        assertTrue(pumpRequest.getConsumption() > 0);
        assertTrue(pumpRequest.getPressure() > 0);

    }
}