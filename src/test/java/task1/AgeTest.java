package task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class AgeTest {

    @Test(expected = RuntimeException.class)
    public void newObjectAgeShouldBePositive(){
        Age age = new Age(5, 11, -4);
    }

    @Test(expected = RuntimeException.class)
    public void fieldsAgeShouldBeReferent(){
        Age age = new Age(5, 13, 1966);
    }
    @Test
    public void returnShouldYear(){
        Age age = new Age(12, 11, 1958);
        assertEquals(12, age.getDay());
    }
    @Test
    public void returnShouldMonth(){
        Age age = new Age(12, 11, 1958);
        assertEquals(11, age.getMonth());
    }
    @Test
    public void returnShouldDay(){
        Age age = new Age(12, 11, 1958);
        assertEquals(1958, age.getYear());

    }

}