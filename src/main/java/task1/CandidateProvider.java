package task1;

import org.checkerframework.checker.formatter.FormatUtil;
import task2.Secretary;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.TreeSet;

public class CandidateProvider {
    public static final Period adultAge = Period.ofYears(18);

    public Collection<Secretary> generateCandidate(int numberOfCandidate, Class<task2.Secretary> clazz) {
        PersonsProvider personsProvider = new PersonsProvider();
        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfCandidate);

        Collection<Secretary> secretaries = new ArrayList<>();
        for (Person p : people) {
            secretaries.add(new Secretary(p));
            //System.out.println(p.age.getYears() );
        }
        return secretaries;
    }

    public class Worker extends Person {
        Integer experience;
        Period possibleExperience;

        public Worker(Person person) {
            Random random = new Random();
            this.birthDate = person.birthDate;
            this.name = person.name;
            this.age = person.age;

            try {
                this.experience = this.getExperience();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //System.out.println(experience);
        }


        public int compareTo(Worker o) {
            return ((Integer) this.age.getYears()).compareTo(o.age.getYears()) * 2;
        }

        public Integer getExperience() throws Exception {
            Random random = new Random();
            Integer possibleExperience;
            possibleExperience = this.age.getYears() - CandidateProvider.adultAge.getYears();
            //System.out.println(possibleExperience);
            if (possibleExperience >= 1) {
                return random.nextInt(possibleExperience);
            }
            else if (possibleExperience == 0) {
                return 0;
            }
            else{
                throw new Exception("Wrong Date");
            }
        }
    }

    public class Secretary extends Worker implements task2.Secretary {
        public Secretary(Person person) {
            super(person);
        }

        @Override
        public void sayHelloTo(Object o) {
            System.out.println("Hi, i'm secretary");
        }
    }

}
