package task1;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person{


    public Name name;
    public BirthDate birthDate;

    public Person(Name name, BirthDate age) {
        // TODO: 5/21/20 o_0 !?!
        this.name = name;
        this.birthDate = age;
    }


    public boolean isYoungerThan(Person person) {
        return this.birthDate.toLocalDate().isAfter(person.birthDate.toLocalDate());
    }


    public Set<Person> getPersons(int qty) {
        Set<Person> result = new HashSet<>();
        while (result.size() != qty) {
            Person person = getPerson();
            result.add(person);
        }
        return result;
    }


    public Person getPerson() {
        return new Person(new Name(), new BirthDate());
    }


    @Override
    public String toString() {
        return "firstName='" + name.firstName + '\'' +
                ", lastName='" + name.lastName + '\'' +
                ", age=" + birthDate.year + " " + birthDate.month + " " + birthDate.day + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }



}
