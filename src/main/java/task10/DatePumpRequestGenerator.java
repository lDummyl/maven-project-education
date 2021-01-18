package task10;


import task8.PumpRequest;
import task8.RequestGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class DatePumpRequestGenerator {
    private final Integer numberOfMonths;
    private final RequestGenerator generator;
    public static final Random random = new Random();

    public DatePumpRequestGenerator() {
        this.numberOfMonths = 12;
        this.generator = new RequestGenerator();
    }

    public List<PumpRequest> generateRequestList(int numberOfRequests) {
        List<PumpRequest> requests = generator.generateRequests(numberOfRequests);
        addData(requests);
        return requests;
    }

    private void addData(List<PumpRequest> requests) {
        LocalDate randomDate = getRandomDate();
        for (PumpRequest request : requests) {
            request.setDateTime(randomDate);
        }
    }

    private LocalDate getRandomDate() {
        LocalDate localDate = null;

        while (localDate == null) {
            int day = 1 + random.nextInt(30);
            int month = 1 + random.nextInt(11);
            try {
                localDate = LocalDate.of(LocalDateTime.now().getYear(), month, day);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return localDate;
    }
}