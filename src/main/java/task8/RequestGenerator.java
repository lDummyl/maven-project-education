package task8;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RequestGenerator {

    private final Random random = new Random();
    private final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public void generateRequestsToJson(File fileWithRequests, int numberOfRequests) {
        mapper.writeValue(fileWithRequests, generateRequests(numberOfRequests));
    }

    public List<PumpRequest> generateRequests(int numberOfRequests) {
        ArrayList<PumpRequest> pumpRequests = new ArrayList<>();
        for (int i = 0; i < numberOfRequests; i++) {
            Double consumption = randomConsumption();
            Double pressure = randomPressure(consumption);
            pumpRequests.add(new PumpRequest(consumption, pressure));
        }
        return pumpRequests;
    }

    private Double randomPressure(Double consumption) {
        return consumption * (1 + random.nextInt(39) + random.nextDouble());
    }

    private Double randomConsumption() {
        return 1.0 + random.nextInt(69) + random.nextDouble();
    }
}