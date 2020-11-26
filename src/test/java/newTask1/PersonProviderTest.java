package newTask1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class PersonProviderTest {

    @Test
    public void generateOnePerson() {
        PersonProvider personProvider = new PersonProvider(1);
        TreeSet<Person> people = personProvider.generatePerson();
        ArrayList<Person> peopleList = new ArrayList<>(people);
        assertNotNull(peopleList.get(0));
        assertNotNull(peopleList.get(0).getBirthDate());
        assertNotNull(peopleList.get(0).getName());
        assertNotNull(peopleList.get(0).getAge());
    }

    @Test
    public void generatePerson() {
        PersonProvider personProvider = new PersonProvider(100);
        TreeSet<Person> people = personProvider.generatePerson();
        ArrayList<Person> peopleList = new ArrayList<>(people);
        assertEquals(personProvider.getNumberOfPersons(), peopleList.size());
    }
    @Test
    public void generateOneAdultPerson() {
        PersonProvider personProvider = new PersonProvider(1);
        int numberOfPersons = 1;
        TreeSet<Person> people = personProvider.generatePerson();
        ArrayList<Person> peopleList = new ArrayList<>(people);
        assertNotNull(peopleList.get(0));
        assertNotNull(peopleList.get(0).getBirthDate());
        assertNotNull(peopleList.get(0).getName());
        assertNotNull(peopleList.get(0).getAge());
        assertTrue(peopleList.get(0).getAge() > PersonProvider.adultAge);
    }
    @Test
    public void generateAdultPerson() {
        PersonProvider personProvider = new PersonProvider(1);
        int numberOfPersons = 1;
        TreeSet<Person> people = personProvider.generatePerson();
        ArrayList<Person> peopleList = new ArrayList<>(people);
        assertNotNull(peopleList.get(0));
        assertEquals(personProvider.getNumberOfPersons(), peopleList.size());

        for (Person person : peopleList) {
            assertNotNull(person);
            assertTrue(person.getAge() > PersonProvider.adultAge);
        }
    }


}