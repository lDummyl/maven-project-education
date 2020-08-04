package task1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LagrangeInterpolatorTest {


    private final Interpolator interpolator = new LagrangeInterpolator();

    @Test
    public void main() {
        interpolator.setPoints(Arrays.asList(new Point(2, 4), new Point(3, 9), new Point(5, 25)));
        double y = interpolator.getY(7);
        assertEquals(49, y, 0.0002);
    }

    @Test
    public void mainNewton() {
        interpolator.setPoints(Arrays.asList(new Point(2, 4), new Point(3, 9), new Point(5, 25)));
        double y = interpolator.getY(7);
        assertEquals(49, y, 0.0002);
    }

    @Test
    public void mainLinear() {
        interpolator.setPoints(Arrays.asList(new Point(2, 3), new Point(4, 9)));
        double y = interpolator.getY(5);
        assertEquals(12, y, 0.0002);
    }

}