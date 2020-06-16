package task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonProviderTest {

    @Test
    public void sumValid() {
        int a = 2;
        int b = 3;


        int actual = a + b;


        assertEquals(5, actual);

    }

    @Test
    public void getSomePerson() {
        PersonProvider menPersonProvider = new PersonProvider();
        Person somePerson = menPersonProvider.getSomePerson();
        assertNotNull(somePerson.getName().lastName);
        assertTrue(PersonProvider.lastN.contains(somePerson.getName().lastName));
//        assertTrue(PersonProvider.firstN.contains(somePerson.getName().lastName));
    }




}