package task10;

import lombok.NoArgsConstructor;
import task8.Pair;
import task8.ReportConstructor;
import task8.SelectionReport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class OrdersConstructor {

    private OrdersGenerator ordersGenerator = new OrdersGenerator();
    private Random random = new Random();

    public PeriodOrdersReport constructOrders(int countOrders, Period period) {
        ReportConstructor reportConstructor = new ReportConstructor((double) random.nextInt(70) + 30);

        ArrayList<List<Pair>> pairsList = ordersGenerator.generateOrders(countOrders, period);
        List<SelectionReport> selectionReports = reportConstructor.generateSelectionReports(pairsList);
        List<OrdersPerMonth> ordersPerMonths = constructOrdersPerMonth(selectionReports, period);

        PeriodOrdersReport periodOrdersReport = new PeriodOrdersReport(ordersPerMonths, period);
        return periodOrdersReport;
    }

    private List<OrdersPerMonth> constructOrdersPerMonth(List<SelectionReport> selectionReports, Period period) {
        if (selectionReports.size() != period.getMonths()) {
            throw new RuntimeException("List sizes mismatch");
        }

        List<OrdersPerMonth> ordersPerMonths = new ArrayList<>();
        LocalDate iterationDate = period.getStart().withDayOfMonth(1);
        LocalDate endDate = period.getEnd().withDayOfMonth(2);
        int index = 0;
        while (iterationDate.isBefore(endDate)) {
            SelectionReport selectionReport = selectionReports.get(index);
            ordersPerMonths.add(new OrdersPerMonth(selectionReport, iterationDate));
            index++;
            iterationDate = iterationDate.plusMonths(1);
        }

        return ordersPerMonths;
    }
}
