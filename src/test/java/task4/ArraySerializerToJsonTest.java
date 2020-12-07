package task4;

import org.junit.*;
import org.junit.Test;
import task1.Person;
import task1.PersonsProvider;
import task3.Resolution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.*;


public class ArraySerializerToJsonTest {

    @Test
    public void serializeCollectionToJSON() {
        OracleQuestionProvider oracleQuestionProvider = new OracleQuestionProvider();
        List<Resolution> resolutions = oracleQuestionProvider.askOracle(1000);

        String file = "newFileJSON";
        ArraySerializerToJson arraySerializerToJson = new ArraySerializerToJson();
        arraySerializerToJson.serializeCollectionToJSON(resolutions, file);
    }
    @Test
    public void deserializeCollectionFromJSON() {
        OracleQuestionProvider oracleQuestionProvider = new OracleQuestionProvider();
        List<Resolution> resolutions = oracleQuestionProvider.askOracle(1000);

        String file = "newFileJSON";
        ArraySerializerToJson arraySerializerToJson = new ArraySerializerToJson();
        arraySerializerToJson.serializeCollectionToJSON(resolutions, file);

        Collection<Resolution> deserialized = arraySerializerToJson.deserializeJsonArray(file, Resolution.class);

        assertEquals(resolutions.size(), deserialized.size());

        for (Resolution resolution : deserialized) {
            assertNotNull(resolution);
            assertEquals(Resolution.class, resolution.getClass());
        }
    }
    // TODO: 07.12.2020 Для составного класса не сработало
    /*@Test
    public void deserializePerson() {
        PersonsProvider personsProvider = new PersonsProvider();
        TreeSet<Person> people = personsProvider.generatePersons(1000);
        ArraySerializerToJson arraySerializerToJson = new ArraySerializerToJson();

        List<Person> peopleList = new ArrayList<>();
        peopleList.addAll(people);

        String file = "newFilePersons";
        arraySerializerToJson.serializeCollectionToJSON(peopleList, file);

        Collection<Person> deserialized = arraySerializerToJson.deserializeJsonArray(file, Person.class);

        assertEquals(people.size(), deserialized.size());

        for (Person person : deserialized) {
            assertNotNull(person);
            assertEquals(Person.class, person.getClass());
        }
    }*/


}