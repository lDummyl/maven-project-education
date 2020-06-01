package task1;

import task2.Secretary;

import java.util.HashSet;
import java.util.Set;

public class PersonProvider {
    public Set<Person> getPersons(int qty) {
        Set<Person> result = new HashSet<>();
        while (result.size() != qty) {
            Person person = getPerson();
            result.add(person);
        }
        return result;
    }

    private Person getPerson() {
        Name name = new Name();
        return new Person(name, new BirthDate());
    }

    public Set<Secretary> getSecretaries(int qty){
        Set<Secretary> result = new HashSet<>();
        Set<Person> persons = getPersons(qty);
        for (Person person : persons) {
            Secretary secretary = new Secretary(person.name, person.birthDate);
            result.add(secretary);
        }
        return result;
    }

}
