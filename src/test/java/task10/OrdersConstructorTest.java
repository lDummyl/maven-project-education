package task10;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class OrdersConstructorTest {

    public static final int COUNT_ORDERS = 30;
    Logger log = Logger.getLogger(OrdersConstructorTest.class.getName());

    Period period = new Period(LocalDateTime.of(2019, 1, 1, 0, 0, 0),
            LocalDateTime.of(2019, 12, 1, 0, 0, 0));

    @Test
    public void OrdersReportPerYearTest() {
        OrdersConstructor ordersConstructor = new OrdersConstructor();
        PeriodOrdersReport periodOrdersReport = ordersConstructor.constructOrders(COUNT_ORDERS, period);

        Optional<Integer> reduce = periodOrdersReport.getOrders().values().stream()
                .map(OrdersPerMonth::getPurchaseCount)
                .reduce(Integer::sum);

        assertEquals(COUNT_ORDERS, reduce.orElse(0).intValue());
    }

    @Test
    public void validValuesTest () {
        OrdersConstructor ordersConstructor = new OrdersConstructor();
        PeriodOrdersReport periodOrdersReport = ordersConstructor.constructOrders(COUNT_ORDERS, period);

        long invalidValues = periodOrdersReport.getOrders().values().stream()
                .filter(i -> i.getPurchaseCount() <= 0).count();

        assertEquals(0, invalidValues);
    }

    @Test
    public void deliveryTest () {
        OrdersConstructor ordersConstructor = new OrdersConstructor();
        PeriodOrdersReport periodOrdersReport = ordersConstructor.constructOrders(COUNT_ORDERS, period);

        Optional<Double> reduce = periodOrdersReport.getOrders().values().stream()
                .map(i -> i.getAvgSum() * i.getPurchaseCount())
                .reduce(Double::sum);
        Double delivery = reduce.orElse(0.) / 10;
        Double deliveryValid = periodOrdersReport.getDelivery();

        assertEquals(deliveryValid, delivery);
    }

    @Test
    public void errorsTest() {
        OrdersConstructor ordersConstructor = new OrdersConstructor();
        PeriodOrdersReport periodOrdersReport = ordersConstructor.constructOrders(COUNT_ORDERS, period);

        Optional<Integer> reduce = periodOrdersReport.getOrders().values().stream()
                .map(OrdersPerMonth::getCountErrors)
                .reduce(Integer::sum);
        assertEquals(0, reduce.orElse(0).intValue());
    }

    @Test
    public void OrdersReportPerThreeMonthTest() {
        int countMonth = 12;
        OrdersConstructor ordersConstructor = new OrdersConstructor();
        PeriodOrdersReport periodOrdersReport = ordersConstructor.constructOrders(COUNT_ORDERS, period);

        assertEquals(countMonth, periodOrdersReport.getOrders().size());
    }

    @Test
    public void OrdersReportPerYearStringTest() {
        OrdersConstructor ordersConstructor = new OrdersConstructor();
        PeriodOrdersReport periodOrdersReport = ordersConstructor.constructOrders(COUNT_ORDERS, period);

        String report = periodOrdersReport.toString();
        log.info(report);
        assertTrue(report.contains("\"purchaseCount\" : " + COUNT_ORDERS + ".0"));
    }
}
