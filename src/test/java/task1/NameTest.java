package task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
    @Test
    public void constructorTest(){
        String firstName = "John";
        String lastName = "Smith";

        Name name = new Name(firstName + " " + lastName);

        assertEquals(firstName, name.getFirstName());
        assertEquals(lastName, name.getLastName());
    }
}