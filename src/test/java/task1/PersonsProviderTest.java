package task1;

import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class PersonsProviderTest {

    @Test
    public void generateAdultPersons() {
        int numberOfPersons = 100;

        PersonsProvider personsProvider = new PersonsProvider();
        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfPersons);
        int i = 1;
        assertEquals(people.size(), numberOfPersons);
        for (Person p : people) {
            assertNotNull(p);
            assertTrue(p.getAge().getYears() >= 18);
            assertEquals(people.size(), numberOfPersons);
        }
    }
    @Test
    public void generatePersons() {
        int adultAge = 18;
        int numberOfPersons = 100;

        PersonsProvider personsProvider = new PersonsProvider();
        TreeSet<Person> people = personsProvider.generatePersons(numberOfPersons);
        int i = 1;
        assertEquals(people.size(), numberOfPersons);
        for (Person p : people) {
            assertNotNull(p);
            assertTrue(p.getAge().getYears() > 0);
            assertEquals(people.size(), numberOfPersons);
        }
    }


}