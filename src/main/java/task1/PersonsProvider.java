package task1;

import task2.Secretary;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.TreeSet;

public class PersonsProvider {
    public static final Integer adultAge = 18;
    public static void main(String[] args) {
        PersonsProvider personsProvider = new PersonsProvider();
        personsProvider.generateCandidate(100, Secretary.class);
    }

    public TreeSet<Person> generatePersons(int numberOfPerons) {
        TreeSet<Person> persons = new TreeSet<>();

        for (int i = 0; i < numberOfPerons; i++) {
            persons.add(new Person());

            //System.out.println(persons.size());
        }
        return persons;
    }

    public TreeSet<Person> generateAdultPersons(int numberOfPersons) {
        TreeSet<Person> persons = new TreeSet<>();

        while (persons.size() < numberOfPersons) {
            Person person = new Person();
            if (person.age.getYears() >= adultAge) {
                persons.add(person);
            }
        }

        return persons;
    }

    public Collection<Secretary> generateCandidate(int numberOfCandidates, Class<Secretary> clazz) {
        TreeSet<Person> people = generateAdultPersons(100);
        Random random = new Random();
            Collection<Secretary> secretaries = new ArrayList<>();
            for (Person p : people) {
                System.out.println(p.age);
                Secretary secretary = new Secretary() {
                    Name name = p.getName();
                    BirthDate birthDate = p.birthDate;
                    Period age = p.age;
                    int experience = random.nextInt(this.age.getYears() - adultAge);

                    @Override
                    public void sayHelloTo(Object o) {
                        System.out.println("Hi, i'm secretary");
                    }
                };
                secretaries.add(secretary);
                System.out.println(secretary);
            }
        return secretaries;
    }
}