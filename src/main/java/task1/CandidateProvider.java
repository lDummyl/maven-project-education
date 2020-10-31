package task1;

import task2.Secretary;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.TreeSet;

public class CandidateProvider {
    public static final Integer adultAge = 18;

    public Collection<Secretary> generateCandidate(int numberOfCandidate, Class<task2.Secretary> clazz) {
        PersonsProvider personsProvider = new PersonsProvider();
        TreeSet<Person> people = personsProvider.generatePersons(numberOfCandidate);
        Collection<Secretary> secretaries = new ArrayList<>();
        for (Person p : people) {
            secretaries.add(new Secretary(p));
        }

        return secretaries;
    }

    public class Worker extends Person {
        Integer experience;

        public Worker(Person person) {
            Random random = new Random();
            this.birthDate = person.birthDate;
            this.name = person.name;
            this.experience = random.nextInt(this.age - adultAge);
            System.out.println(experience);
        }
    }

    class Secretary extends Worker implements task2.Secretary {
        public Secretary(Person person) {
            super(person);
        }

        @Override
        public void sayHelloTo(Object o) {
            System.out.println("Hi, i'm secretary");
        }
    }

}
