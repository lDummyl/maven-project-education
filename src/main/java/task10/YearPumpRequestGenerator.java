package task10;


import task8.PumpRequest;
import task8.RequestGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;


public class YearPumpRequestGenerator {
    private final RequestGenerator generator;
    public static final Random random = new Random();

    public YearPumpRequestGenerator() {
        this.generator = new RequestGenerator();
    }

    public List<PumpRequest> generateRequestList(int numberOfRequests) {
        List<PumpRequest> requests = generator.generateRequests(numberOfRequests);
        addData(requests);
        return requests;
    }

    private void addData(List<PumpRequest> requests) {
        for (PumpRequest request : requests) {
            request.setDateTime(getRandomDate());
        }
    }

    private LocalDate getRandomDate() {
        int daysInYear = LocalDate.now().lengthOfYear();
        return LocalDate.ofYearDay(LocalDate.now().getYear(), random.nextInt(daysInYear));
    }
}