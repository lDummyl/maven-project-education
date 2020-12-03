package task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class BirthDateTest {


    @Test
    public void generateBirthDate() {
        BirthDate birthDate = new BirthDate(2020);
        assertNotNull(birthDate);
    }

    @Test
    public void before() {
        BirthDate birthDate1 = new BirthDate(11, 10, 1998);
        BirthDate birthDate2 = new BirthDate(11, 10, 1988);
        BirthDate birthDate3 = new BirthDate(11, 11, 1988);
        BirthDate birthDate4 = new BirthDate(12, 11, 1988);
        assertTrue(birthDate2.before(birthDate1));
        assertTrue(birthDate2.before(birthDate3));
        assertTrue(birthDate3.before(birthDate4));
    }
}