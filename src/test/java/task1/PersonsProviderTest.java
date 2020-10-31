package task1;

import org.junit.Test;
import task2.Secretary;

import java.util.ArrayList;
import java.util.Collection;
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
            assertTrue(p.age >= 18);
        }
    }

    @Test
    public void generateCandidate() {
        int numberOfCandidates = 100;

        PersonsProvider personsProvider = new PersonsProvider();
        ArrayList<task2.Secretary> objects = (ArrayList<task2.Secretary>) personsProvider.generateCandidate(100,Secretary.class);
        objects.get(0).sayHelloTo(1);

    }
}