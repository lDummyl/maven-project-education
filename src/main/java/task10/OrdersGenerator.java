package task10;

import lombok.NoArgsConstructor;
import task8.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class OrdersGenerator {

    private int MIN_VALUE = 2;
    private int MAX_VALUE = 12;
    private Random random = new Random();

    public List<List<Pair>> generateOrders(int countOrders, Period period) {
        int countMonths = period.getMonths();
        ArrayList<List<Pair>> pairsList = new ArrayList<>();

        int avg = countOrders / countMonths;
        int surplus = countOrders - avg * countMonths;
        for (int i = 1; i <= countMonths; i++) {
            int countOrdersPerMont = (i <= surplus ? avg + 1 : avg);
            List<Pair> pairs = generateOrders(countOrdersPerMont);
            pairsList.add(pairs);
        }

        return pairsList;
    }

    // TODO: 10/14/19 повышай информативность названий в коде, гет это получить что-то существующее.
    private List<Pair> generateOrders(int necessaryQty) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < necessaryQty; i++) {
            int flow = random.nextInt(MAX_VALUE) + MIN_VALUE;
            int pressure = random.nextInt(MAX_VALUE) + flow;
            Pair pair = new Pair((double) flow, (double) pressure);
            pairs.add(pair);
        }
        return pairs;
    }
}
