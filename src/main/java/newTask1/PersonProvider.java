package newTask1;

import task2.Worker;

import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonProvider {
    private final int numberOfPersons;
    public static final int adultAge = 18;

    public PersonProvider(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public TreeSet<Person> generatePerson() {
        TreeSet<Person> people = new TreeSet<>();
        while (people.size() < numberOfPersons) {
            people.add(new Person());
        }
        return people;
    }

    public TreeSet<Person> generateAdultPerson() {
        TreeSet<Person> people = new TreeSet<>();
        while (people.size() < numberOfPersons) {
            Person person = new Person();
            if (PersonProvider.adultAge >= 18) {
                people.add(person);
            }
        }
        return people;
    }

    // TODO: 26.11.2020 тест
    public <T extends Worker> List<T> generateAnyWorker(Function<Person, T> constructorRef, int numberOfWorkers) {
        PersonProvider personProvider = new PersonProvider(numberOfWorkers);
        TreeSet<Person> people = personProvider.generateAdultPerson();
        return people.stream().map(constructorRef).collect(Collectors.toList());
    }
}
