package task8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class RequestGeneratorTest {

    @Test
    public void generateOneRequest() {
        int numberOfRequests = 1;

        RequestGenerator requestGenerator = new RequestGenerator();
        List<PumpRequest> requests = requestGenerator.generateRequests(numberOfRequests);

        assertEquals(numberOfRequests, requests.size());
        assertTrue(requests.get(0).getConsumption() >0);
        assertTrue(requests.get(0).getPressure() >0);
    }
    @Test
    public void generateManyRequest() {
        int numberOfRequests = 1000;

        RequestGenerator requestGenerator = new RequestGenerator();
        List<PumpRequest> requests = requestGenerator.generateRequests(numberOfRequests);

        assertEquals(numberOfRequests, requests.size());
        for (PumpRequest request : requests) {
            assertTrue(request.getConsumption() > 0);
            assertTrue(request.getPressure() > 0);
        }
    }
    @Test
    @SneakyThrows
    public void generateManyRequestToFile() {
        int numberOfRequests = 1000;
        File requestFile = new File("RequestFile.json");

        RequestGenerator requestGenerator = new RequestGenerator();
        requestGenerator.generateRequestsToJson(requestFile, numberOfRequests);

        ObjectMapper objectMapper = new ObjectMapper();
        List<PumpRequest> requests = objectMapper.readValue(requestFile, new TypeReference<List<PumpRequest>>() {
        });

        assertEquals(numberOfRequests, requests.size());
        for (PumpRequest request : requests) {
            assertTrue(request.getConsumption() > 0);
            assertTrue(request.getPressure() > 0);
        }
    }
}