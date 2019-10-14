package task10;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Getter;
import lombok.SneakyThrows;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
public class PeriodOrdersReport {

    private transient ObjectMapper mapper = new ObjectMapper();

    private final Period period;
    private Map<LocalDate, OrdersPerMonth> orders = new TreeMap<>();
    private Double purchaseCount = 0.;
    private Double delivery = 0.;

    {
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public PeriodOrdersReport(List<OrdersPerMonth> ordersPerMonths, Period period) {
        this.period = period;
        spreadByMonth(ordersPerMonths, period.getMonths());
    }

    private void spreadByMonth(List<OrdersPerMonth> ordersPerMonths, int countMonths) {
        if (ordersPerMonths.size() != countMonths) {
            throw new RuntimeException("List sizes mismatch");
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
        return mapper.writeValueAsString(this); // в таким виде мне ругается в тесте на бесконечную рекурсию, пока не понял почему
    }
}
