package task1;

import org.junit.Test;
import task2.Secretary;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class PersonsProviderTest {

    private Object Secretary;

    @Test
    public void generateAdultPersons() {
        int adultAge = 18;
        int numberOfPersons = 100;

        PersonsProvider personsProvider = new PersonsProvider();
        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfPersons);
        int i = 1;
        assertTrue(people.size() == numberOfPersons);
        for (Person p : people) {
            assertTrue(p != null);
            assertTrue(p.age.getYears() >= 18);
        }
    }

    @Test
    public void generateCandidate() {

        PersonsProvider personsProvider = new PersonsProvider();
        int numberOfCandidates = 100;
        //TreeSet<Object> objects =   personsProvider.generateCandidate(100,Secretary.class);
    }
}