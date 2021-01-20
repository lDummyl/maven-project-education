package task10;


import task8.PumpRequest;
import task8.RequestGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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

    // FIXME: 1/20/2021 Иногда кидает java.time.DateTimeException: Invalid value for DayOfYear (valid values 1 - 365/366): 0
    private LocalDate getRandomDate() {
        int daysInYear = LocalDate.now().lengthOfYear();
        LocalDate localDate = LocalDate.ofYearDay(LocalDate.now().getYear(), random.nextInt(daysInYear));
        Optional<Object> empty = Optional.empty();
       // empty.
        return null;
    }
}