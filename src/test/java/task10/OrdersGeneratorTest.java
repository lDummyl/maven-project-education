package task10;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals(2019, (int) ordersReportPerYear.getYear());
    }

    // тесты еще не дописал
}