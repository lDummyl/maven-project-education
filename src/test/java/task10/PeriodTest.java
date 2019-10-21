package task10;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class PeriodTest {

    Logger log = Logger.getLogger(OrdersConstructorTest.class.getName());

    @Test
    public void monthTest () {
        Period period = new Period(LocalDateTime.of(2017, 6, 1, 0, 0, 0),
                LocalDateTime.of(2019, 12, 1, 0, 0, 0));

        assertEquals(31, period.getMonths());
    }

    @Test
    public void dateDayTest () {
        Period period = new Period(LocalDateTime.of(2019, 1, 5, 0, 0, 0),
                LocalDateTime.of(2019, 12, 10, 0, 0, 0));

        log.info(period.getStart().withDayOfMonth(1) + "\n" + period.getEnd());
    }

    @Test
    public void plusMonthTest () {
        Period period = new Period(LocalDateTime.of(2019, 1, 1, 0, 0, 0),
                LocalDateTime.of(2019, 12, 1, 0, 0, 0));

        log.info(period.getStart() + "\n" + period.getStart().plusMonths(1));
    }
}