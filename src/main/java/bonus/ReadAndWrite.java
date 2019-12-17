package bonus;

import lombok.SneakyThrows;
import lombok.Synchronized;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// TODO: 12/13/19 Внимательно разбери этот кейс и сопоставь со своим решением.

public class ReadAndWrite {
    static final Random random = new Random();
    private static final String petya = "Petya";

    // TODO: 12/13/19 в данном случае не важно какая коллекция, важно что добавление идет атомарной синхронизированной операцией
    static Map<String, Report> averageSalary = new HashMap<>();
//    static Map<String, Report> averageSalary = new ConcurrentHashMap<>();


    public static void main(String[] args) {

        List<PayCheck> petyaAvoirs = Stream.generate(() -> new PayCheck(petya, random.nextInt(1000))).limit(100).collect(Collectors.toList());

        LocalTime start = LocalTime.now();
        petyaAvoirs.stream().forEach(p -> {
            doLotsOfWork();
            syncWrite(p);
        });

        System.out.println("Duration sequential = " + Duration.between(start, LocalTime.now()).getSeconds());
        Double averageSequential = averageSalary.get(petya).average;
        System.out.println("Sequential average = " + averageSequential);

        start = LocalTime.now();
        petyaAvoirs.parallelStream().forEach(p -> {
            doLotsOfWork();
            syncWrite(p);
        });

        System.out.println("Duration parallel = " + Duration.between(start, LocalTime.now()).getSeconds());
        Double average1 = averageSalary.get(petya).average;
        System.out.println("Parallel average = " + average1);
        OptionalDouble average = petyaAvoirs.stream().mapToInt(i -> i.summ).average();
        System.out.println("Etalon average = " + average.getAsDouble());

    }

    @SneakyThrows
    @Synchronized
    // TODO: 12/13/19 если синхронизировать эту операцию то профита по времени не будет. При этом если убрать то не изменится и результат.
    private static void doLotsOfWork() {
        Thread.sleep(100);
    }


    @Synchronized
    // TODO: 12/13/19 только здесь это важно, тебе в руки дают журнал только чтобы ты успел "найти последнюю строчку и вписать себя" и сразу отдать следующему,
    //  а не на день с ним походить в магазин в кино и потом сделать запись и отдать.
    private static void syncWrite(PayCheck p) {
        Report report = averageSalary.merge(p.name, new Report(p.summ, 1, (double) p.summ), (a, b) -> {
            a.payTimes += b.payTimes;
            a.summ += b.summ;
            a.average = (double) a.summ / a.payTimes;
            return a;
        });
        report.payTimes++;
        report.summ += p.summ;
        report.average = report.summ / (double) report.payTimes;
    }

    static class PayCheck {
        String name;
        Integer summ;

        public PayCheck(String name, Integer summ) {
            this.name = name;
            this.summ = summ;
        }
    }

    static class Report {
        Integer summ = 0;
        Integer payTimes = 0;
        Double average = 0.;

        public Report(Integer summ, Integer payTimes, Double average) {
            this.summ = summ;
            this.payTimes = payTimes;
            this.average = average;
        }
    }
}
