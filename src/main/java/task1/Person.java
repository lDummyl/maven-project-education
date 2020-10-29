package task1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

// TODO: 9/12/20 тройка с минусом
// Что нужно улучшить для увеличения оценки?

public class Person implements Comparable<Person> {
    Name name;
    BirthDate birthDate;
    Period age;


    public Name getName() {
        return name;
    }

    public BirthDate getBirthDate() {
        return birthDate;
    }


    public Person(String name, BirthDate localbirthDate) {
        this.name = new Name(name);
        this.birthDate = localbirthDate;
    }

    public Period getAge() {
        return age;
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



