package task10;

import lombok.NoArgsConstructor;
import task8.Pair;
import task8.PumpBatchRequest;
import task8.PumpBatchRequestsArchive;

import java.time.LocalDateTime;
import java.util.Random;

@NoArgsConstructor
public class OrdersGenerator {

    private int MIN_VALUE = 2;
    private int MAX_VALUE = 12;
    private Random random = new Random();

    public PumpBatchRequestsArchive generateOrders(int countOrders, Period period) {
        int countMonths = period.getMonths();
        PumpBatchRequestsArchive pumpBatchRequestsArchive = new PumpBatchRequestsArchive(period.getStart(), period.getEnd(), countOrders);

        int avg = countOrders / countMonths;
        int surplus = countOrders - avg * countMonths;
        LocalDateTime iterationDate = period.getStart().withDayOfMonth(1);
        LocalDateTime endDate = period.getEnd().withDayOfMonth(2);
        int iterationMonth = 1;

        while (iterationDate.isBefore(endDate)) {
            int countOrdersPerMont = (iterationMonth <= surplus ? avg + 1 : avg);
            PumpBatchRequest pumpBatchRequest = generateOrders(countOrdersPerMont, iterationDate);
            pumpBatchRequestsArchive.requests.add(pumpBatchRequest);
            iterationMonth++;
            iterationDate = iterationDate.plusMonths(1);
        }

        return pumpBatchRequestsArchive;
    }

    // TODO: 10/14/19 повышай информативность названий в коде, гет это получить что-то существующее.
    private PumpBatchRequest generateOrders(int necessaryQty, LocalDateTime date) {
        PumpBatchRequest pumpBatchRequest = new PumpBatchRequest(date);
        for (int i = 0; i < necessaryQty; i++) {
            int flow = random.nextInt(MAX_VALUE) + MIN_VALUE;
            int pressure = random.nextInt(MAX_VALUE) + flow;
            Pair pair = new Pair((double) flow, (double) pressure);
            pumpBatchRequest.pairs.add(pair);
        }
        return pumpBatchRequest;
    }
}
