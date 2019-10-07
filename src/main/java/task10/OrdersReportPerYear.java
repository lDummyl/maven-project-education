package task10;

import lombok.Getter;
import task8.SelectionReport;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class OrdersReportPerYear {

    private final Integer year;
    private Map<LocalDate, OrdersPerMonth> orders = new HashMap<>();
    private Double purchaseCount = 0.;
    private Double delivery = 0.;

    public OrdersReportPerYear(List<SelectionReport> selectionReports, Integer countMonths, Integer year) {
        this.year = year;
        spreadByMonth(selectionReports, countMonths);
    }

    private void spreadByMonth(List<SelectionReport> selectionReports, int countMonths) {
        if (selectionReports.size() != countMonths) {
            throw new RuntimeException("List sizes mismatch");
        }

        for (int i = 0; i < countMonths; i++) {
            SelectionReport selectionReport = selectionReports.get(i);
            OrdersPerMonth ordersPerMonth = new OrdersPerMonth(selectionReport.commercialUnit);

            purchaseCount += ordersPerMonth.getPurchaseCount();
            delivery += ordersPerMonth.getDelivery();
            LocalDate month = LocalDate.of(year, i + 1, 1);

            orders.put(month, ordersPerMonth);
        }
    }
}
