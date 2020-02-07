package task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class AgeTest {

    @Test
    public void fullYearToDaysTest() {
        Age age = new Age(1901,02,03);
        int result = age.fullYearToDays();
        System.out.println(result);
        assertEquals(365+31+3, result);
    }

    @Test
    public void fullYearToDaysTest2() {
        Age age = new Age(1902,01,10);
        int result = age.fullYearToDays();
        System.out.println(result);
        assertEquals(365+365+10, result);
    }
}