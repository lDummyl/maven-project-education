package task1;

import task2.Secretary;

import java.time.Period;
import java.util.Random;
import java.util.TreeSet;

public class PersonsProvider {
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
            if (person.age.getYears() >= 18) {
                persons.add(person);
            }
        }
        return persons;
    }

    public <T> TreeSet<T> generateCandidate(int numberOfCandidates, Class<T> clazz) {
        TreeSet<Person> people = generateAdultPersons(100);

        Random random = new Random();
        if (clazz.equals(Secretary.class)) {
            TreeSet<Secretary> secretaries = new TreeSet<>();
            for (Person p : people) {

                Secretary secretary = new Secretary() {
                    Name name = p.getName();
                    BirthDate birthDate = p.birthDate;
                    Period age = p.getAge();
                    Integer experience = random.nextInt(this.age.getYears() - 18);

                    @Override
                    public void sayHelloTo(Object o) {
                        System.out.println("Hi, i'm secretary");
                    }

                };
                //secretaries.add(secretary);
                System.out.println(secretary.getClass());
            }
            //return secretaries;
        }
        return null;
    }


    public void oldestSearch(TreeSet<Person> set) {
        System.out.println(set.first().birthDate.localBirthDate);
    }
    /*
    public void oldestSearchT(ArrayList<Human> list) {


        int oldest = 0;
        // TODO: 9/10/20 подумай насчет инкапсуляции и здесь, чтобы зделать код лаконичней и наглядней
        LocalDate min = list.get(0).birthDate.localBirthDate;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i).birthDate.localBirthDate.isBefore(min)) {
                min = list.get(i).birthDate.localBirthDate;
                oldest = i;

            }
        }
        System.out.println(list.get(oldest).birthDate.localBirthDate);
    }
    */
}