package MyCodeWars;

import junit.framework.TestCase;

public class TwoSumTest extends TestCase {

    public void testTwoSum() {
        int testArray[] = {1234,5678,9012};

        int[] ints = new int[2];
        ints = TwoSum.twoSum(testArray, 14690);
        System.out.println(ints[0] + " " + ints[1]);
        assertEquals(1,ints[0]);
        assertEquals(2,ints[1]);

    }
}