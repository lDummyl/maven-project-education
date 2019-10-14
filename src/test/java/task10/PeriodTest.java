package task10;

import org.junit.Test;

import java.time.LocalDate;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class PeriodTest {

    Logger log = Logger.getLogger(OrdersConstructorTest.class.getName());

    @Test
    public void monthTest () {
        Period period = new Period(LocalDate.of(2019, 6, 1),
                LocalDate.of(2019, 12, 1));

        assertEquals(7, period.getMonths());
    }

    @Test
    public void dateDayTest () {
        Period period = new Period(LocalDate.of(2019, 1, 5),
                LocalDate.of(2019, 12, 10));

        log.info(period.getStart().withDayOfMonth(1) + "\n" + period.getEnd());
    }

    @Test
    public void plusMonthTest () {
        Period period = new Period(LocalDate.of(2019, 1, 1),
                LocalDate.of(2019, 12, 1));

        log.info(period.getStart() + "\n" + period.getStart().plusMonths(1));
    }
}