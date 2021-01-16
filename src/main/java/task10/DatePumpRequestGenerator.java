package task10;


import task8.PumpRequest;
import task8.RequestGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DatePumpRequestGenerator {
    Integer monthPeriod;
    Integer numberOfRequestsInMoment;
    Integer numberOfGeneration;
    RequestGenerator generator;
    public static final Random random = new Random();

    public DatePumpRequestGenerator() {
        this.monthPeriod = 12;
        this.numberOfRequestsInMoment = 10;
        this.generator = new RequestGenerator();
        this.numberOfGeneration = 100;
    }


    public List<List<PumpRequest>> generateRequests() {
        // TODO: 16.01.2021 декларативней наглядней и короче
//        return Stream.generate(this::getRequestList).limit(numberOfGeneration).collect(Collectors.toList())
        ArrayList<List<PumpRequest>> lists = new ArrayList<>();
        for (int i = 0; i < numberOfGeneration; i++) {
            lists.add(getRequestList());
        }
        return lists;

    }

    private List<PumpRequest> getRequestList() {
        List<PumpRequest> requests = generator.generateRequests(numberOfRequestsInMoment);
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
        // TODO: 16.01.2021 короче и изящней, изучай либы, есть масса способов.
//        int daysInYear = Year.of(2020).length();
//        return LocalDate.ofYearDay(2020, daysInYear).minusDays(random.nextInt(daysInYear));
        LocalDate localDate = null;

        while (localDate == null) {
            int day = 1 + random.nextInt(30);
            int month = 1 + random.nextInt(11);
            try {
                localDate = LocalDate.of(LocalDateTime.now().getYear(), month, day);
            } catch (Exception e) {

            }
        }
        return localDate;

    }
}