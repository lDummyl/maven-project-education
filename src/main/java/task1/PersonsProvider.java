package task1;

import java.util.TreeSet;

public class PersonsProvider {
    public static final Integer adultAge = 18;

    public TreeSet<Person> generatePersons(int numberOfPersons) {
        TreeSet<Person> persons = new TreeSet<>();

        for (int i = 0; i < numberOfPersons; i++) {
            persons.add(new Person());
        }
        return persons;
    }

    public TreeSet<Person> generateAdultPersons(int numberOfPersons) {
        TreeSet<Person> persons = new TreeSet<>();

        while (persons.size() < numberOfPersons) {
            Person person = new Person();
            if (person.getAge().getYears() >= adultAge) {
                persons.add(person);
            }
        }
        return persons;
    }
}