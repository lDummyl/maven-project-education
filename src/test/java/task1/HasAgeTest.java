package task1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HasAgeTest {

    @Test
    public void getOldest() {
        Person person1 = new Person(new Name(), new BirthDate(11, 2, 1990));
        Person person2 = new Person(new Name(), new BirthDate(11, 2, 1980));
        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);

        Person result = HasAge.getOldest(people);
        assertEquals(person2, result);
    }
}