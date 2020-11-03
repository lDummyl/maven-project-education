package task1;

import org.junit.Test;
import task2.SecretaryImpl;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class PersonsProviderTest {

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
            //System.out.println(p.age.getYears());
            assertTrue(people.size() == numberOfPersons);
        }
    }

    @Test
    public void generateCandidate() {
        int numberOfCandidates = 100;

        PersonsProvider personsProvider = new PersonsProvider();
        ArrayList<SecretaryImpl> objects = (ArrayList<SecretaryImpl>) personsProvider.generateCandidate(100, SecretaryImpl.class);


    }
}