package task10;

import org.junit.Test;

import java.time.LocalDate;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class OrdersGeneratorTest {

    Logger log = Logger.getLogger(OrdersGeneratorTest.class.getName());

    @Test
    public void OrdersReportPerYearTest () {
        OrdersGenerator ordersGenerator = new OrdersGenerator();
        OrdersReportPerYear ordersReportPerYear = ordersGenerator.generateOrders(30, 70.);

        int countOrders = 0;
        for (OrdersPerMonth ordersPerMonth : ordersReportPerYear.getOrders().values()) {
            countOrders += ordersPerMonth.getPurchaseCount();
        }

        assertEquals(30, countOrders);
        assertEquals(LocalDate.now().getYear(), (int) ordersReportPerYear.getYear());
    }

    @Test
    public void errorsTest () {
        OrdersGenerator ordersGenerator = new OrdersGenerator();
        OrdersReportPerYear ordersReportPerYear = ordersGenerator.generateOrders(30, 70.);

        for (OrdersPerMonth ordersPerMonth : ordersReportPerYear.getOrders().values()) {
            assertNotNull(ordersPerMonth.getCountErrors());
            assertEquals(0, (int) ordersPerMonth.getCountErrors());
        }
    }

    @Test
    public void OrdersReportPerThreeMonthTest () {
        int countMonth = 3;
        OrdersGenerator ordersGenerator = new OrdersGenerator();
        OrdersReportPerYear ordersReportPerYear = ordersGenerator.generateOrders(
                30, 70., 2019, countMonth, 2);

        assertEquals(countMonth, ordersReportPerYear.getOrders().size());
    }

    @Test
    public void OrdersReportPerYearStringTest () {
        OrdersGenerator ordersGenerator = new OrdersGenerator();
        String report = ordersGenerator.generateOrdersString(30, 70.);

        log.info(report);
        assertTrue(report.contains("\"purchaseCount\" : 30.0"));
    }
}