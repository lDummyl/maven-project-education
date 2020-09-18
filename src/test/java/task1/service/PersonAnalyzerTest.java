package task1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task1.model.Name;
import task1.model.Person;
import task1.util.NameGenerator;
import task1.util.PersonGenerator;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

class PersonAnalyzerTest {

    private List<Name> names;
    private List<Person> persons;
    private PersonAnalyzer pa;

    @BeforeEach
    void setup() {
        names = new NameGenerator().generate();
        persons = new PersonGenerator().generate();
        pa = new PersonAnalyzer();
    }

    @Test
    void getOldestNotNullTest() {
        assertNotNull(names);
    }

    @Test
    void getOldestArgumentsSizeTest() {
        assertTrue(names.size() > 0);
    }

    @Test
    void getOldestResultTest() {
        assertEquals("The oldest one is: Sergey Sergeev", pa.getOldest(persons));
    }

    @Test
    void getOldestNamesListSizeTest() {
        assertThat(persons, hasSize(5));
    }

    @Test
    void getRandomPersonsListNotNullTest() {
        assertNotNull(persons);
    }

    @Test
    void getRandomPersonsListSizeTest() {
        assertThat(names, hasSize(10));
    }

}