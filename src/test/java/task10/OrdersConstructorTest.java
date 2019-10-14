package task10;

import org.junit.Test;

import java.time.LocalDate;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class OrdersConstructorTest {

    Logger log = Logger.getLogger(OrdersConstructorTest.class.getName());

    Period period = new Period(LocalDate.of(2019, 1, 1),
            LocalDate.of(2019, 12, 1));

    @Test
    public void OrdersReportPerYearTest () {
        OrdersConstructor ordersConstructor = new OrdersConstructor();
        PeriodOrdersReport periodOrdersReport = ordersConstructor.constructOrders(30, period);

        int countOrders = 0;
        for (OrdersPerMonth ordersPerMonth : periodOrdersReport.getOrders().values()) {
            countOrders += ordersPerMonth.getPurchaseCount();
        }

        assertEquals(30, countOrders);
    }

    @Test
    public void errorsTest () {
        OrdersConstructor ordersConstructor = new OrdersConstructor();
        PeriodOrdersReport periodOrdersReport = ordersConstructor.constructOrders(30, period);

        for (OrdersPerMonth ordersPerMonth : periodOrdersReport.getOrders().values()) {
            assertNotNull(ordersPerMonth.getCountErrors());
            assertEquals(0, (int) ordersPerMonth.getCountErrors());
        }
    }

    @Test
    public void OrdersReportPerThreeMonthTest () {
        int countMonth = 12;
        OrdersConstructor ordersConstructor = new OrdersConstructor();
        PeriodOrdersReport periodOrdersReport = ordersConstructor.constructOrders(30, period);

        assertEquals(countMonth, periodOrdersReport.getOrders().size());
    }

    @Test
    public void OrdersReportPerYearStringTest () {
        OrdersConstructor ordersConstructor = new OrdersConstructor();
        PeriodOrdersReport periodOrdersReport = ordersConstructor.constructOrders(30, period);

        String report = periodOrdersReport.toString();
        log.info(report);
        assertTrue(report.contains("\"purchaseCount\" : 30.0"));
    }
}
