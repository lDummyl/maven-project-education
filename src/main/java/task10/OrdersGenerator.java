package task10;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import task8.Pair;
import task8.ReportConstructor;
import task8.SelectionReport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class OrdersGenerator {

    private int MIN_VALUE = 2;
    private int MAX_VALUE = 12;
    private ObjectMapper mapper = new ObjectMapper();
    private Random random = new Random();

    {
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public OrdersReportPerYear generateOrders(int countOrders, double ratioPercent, int year, int countMonths, double factorPressure) {
        List<SelectionReport> selectionReports = generateReports(countOrders, ratioPercent, countMonths, factorPressure);
        OrdersReportPerYear ordersReportPerYear = new OrdersReportPerYear(selectionReports, countMonths, year);

        return ordersReportPerYear;
    }

    public OrdersReportPerYear generateOrders(int countOrders, double ratioPercent) {
        int year = LocalDate.now().getYear();
        return generateOrders(countOrders, ratioPercent, year, 12, 2.);
    }

    public String generateOrdersString(int countOrders, double ratioPercent, int year, int countMonths, double factorPressure) {
        OrdersReportPerYear ordersReportPerYear = generateOrders(countOrders, ratioPercent, year, countMonths, factorPressure);
        return getOrdersString(ordersReportPerYear);
    }

    public String generateOrdersString(int countOrders, double ratioPercent) {
        OrdersReportPerYear ordersReportPerYear = generateOrders(countOrders, ratioPercent);
        return getOrdersString(ordersReportPerYear);
    }

    @SneakyThrows
    private String getOrdersString(OrdersReportPerYear ordersReportPerYear) {
        return ordersReportPerYear != null ? mapper.writeValueAsString(ordersReportPerYear) : "";
    }

    private List<SelectionReport> generateReports(int countOrders, double ratioPercent, int countMonths, double factorPressure) {
        ReportConstructor reportConstructor = new ReportConstructor(ratioPercent);
        ArrayList<List<Pair>> pairsList = new ArrayList<>();

        int avg = countOrders / countMonths;
        int surplus = countOrders - avg * countMonths;
        for (int i = 1; i <= countMonths; i++) {
            int countOrdersPerMont = (i <= surplus ? avg + 1 : avg);
            List<Pair> pairs = getOrders(countOrdersPerMont, factorPressure);
            pairsList.add(pairs);
        }

        return reportConstructor.generateSelectionReports(pairsList);
    }

    private List<Pair> getOrders(int countOrders, double factorPressure) {
        if (factorPressure > 4.) {
            factorPressure = 4.;
        }

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < countOrders; i++) {
            int flow = random.nextInt(MAX_VALUE) + MIN_VALUE;
            Pair pair = new Pair((double) flow, flow * factorPressure);
            pairs.add(pair);
        }
        return pairs;
    }
}
