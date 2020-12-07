package task1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;


public class Person implements Comparable<Person> {
    public Name name;
    public BirthDate birthDate;
    public Period age;

    public Person(String name, BirthDate localBirthDate) {
        this.name = new Name(name);
        this.birthDate = localBirthDate;
    }


    public Person(Name name, BirthDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person() {
        this.name = new Name();
        this.birthDate = new BirthDate();
        this.age = Period.between(birthDate.localBirthDate, LocalDate.now());
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

    @Override
    public int compareTo(Person o) {
        return this.birthDate.compareTo(o.birthDate);
    }
}



