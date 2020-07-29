package task1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LagrangeInterpolatorTest {

    @Test
    public void main() {
        Interpolator lagrangeInterpolator = new LagrangeInterpolator();
        lagrangeInterpolator.setPoints(Arrays.asList(new Point(2, 4), new Point(3, 9), new Point(5, 25)));
        double y = lagrangeInterpolator.getY(7);
        assertEquals(49, y, 0.0002);
    }

    @Test
    public void mainNewton() {
        Interpolator lagrangeInterpolator = new NewtonInterpolator();
        lagrangeInterpolator.setPoints(Arrays.asList(new Point(2, 4), new Point(3, 9), new Point(5, 25)));
        double y = lagrangeInterpolator.getY(7);
        assertEquals(49, y, 0.0002);
    }
}