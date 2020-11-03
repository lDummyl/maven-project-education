package task1;

import task2.SecretaryImpl;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.TreeSet;

public class PersonsProvider {
    public static final Integer adultAge = 18;
    public static void main(String[] args) {
        PersonsProvider personsProvider = new PersonsProvider();
        personsProvider.generateCandidate(100, SecretaryImpl.class);
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

    public Collection<SecretaryImpl> generateCandidate(int numberOfCandidates, Class<SecretaryImpl> clazz) {
        TreeSet<Person> people = generateAdultPersons(100);
        Random random = new Random();
            Collection<SecretaryImpl> secretaries = new ArrayList<>();
            for (Person p : people) {

                SecretaryImpl secretaryImpl = new SecretaryImpl(new Person()) {
                    Name name = p.getName();
                    BirthDate birthDate = p.birthDate;
                    Period age = p.age;
                    // FIXME: 11/2/20 тут вылетает эксепшон
                    int experience;

                    {
                        try {
                            experience = this.getExperience();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    public Integer getExperience(){
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
                            throw new IllegalStateException("Wrong Date");
                        }
                    }
                    @Override
                    public void sayHelloTo(Object o) {
                        System.out.println("Hi, i'm secretary");
                    }
                };
                secretaries.add(secretaryImpl);
            }
        return secretaries;
    }
}