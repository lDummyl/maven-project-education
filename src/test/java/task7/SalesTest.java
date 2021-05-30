package task7;

import org.junit.Test;
import task8.Sales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SalesTest {

    @Test
    public void sumOverTenThousands(){
        List list = new ArrayList();
        list.add(new CirculatingPump("testPump", Arrays.asList(new HydraulicCharacteristics(2.2f, 3.3f)), 750000.00));
        Sales sales = new Sales();
        double x = sales.getTotalSum(list);
        assertEquals(10049.58, x, 0.01);
    }

    @Test
    public void sumBelowTenThousands(){
        List list = new ArrayList();
        list.add(new CirculatingPump("testPump", Arrays.asList(new HydraulicCharacteristics(2.2f, 3.3f)), 74630.00));
        Sales sales = new Sales();
        double x = sales.getTotalSum(list);
        assertEquals(1100.00, x, 0.001);
    }

}