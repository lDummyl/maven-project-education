package task10;

import lombok.Getter;
import lombok.SneakyThrows;
import task7.ErrorMessage;
import task7.RuntimeExceptionImp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
public class PeriodOrdersReport {

    private final Period period;
    private Map<LocalDateTime, OrdersPerMonth> orders = new TreeMap<>();
    private Double purchaseCount = 0.;
    private Double delivery = 0.;

    public PeriodOrdersReport(List<OrdersPerMonth> ordersPerMonths, Period period) {
        this.period = period;
        spreadByMonth(ordersPerMonths, period.getMonths());
      }

    private void spreadByMonth(List<OrdersPerMonth> ordersPerMonths, int countMonths) {
        if (ordersPerMonths.size() != countMonths) {
            throw new RuntimeExceptionImp(ErrorMessage.LIST_SIZES_MISMATCH);
        }

        for (OrdersPerMonth ordersPerMonth : ordersPerMonths) {
            purchaseCount += ordersPerMonth.getPurchaseCount();
            delivery += ordersPerMonth.getDelivery();
            orders.put(ordersPerMonth.getMount(), ordersPerMonth);
        }
    }

    @Override
    @SneakyThrows
    public String toString() {
        return Util.mapper.writeValueAsString(this);
    }
}
