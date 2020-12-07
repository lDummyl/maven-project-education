package task1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import task4.JsonReady;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

// TODO: 9/12/20 тройка с минусом
// Что нужно улучшить для увеличения оценки?
@JsonAutoDetect
public class Person implements Comparable<Person>, JsonReady {
    public Name name;
    public BirthDate birthDate;
    public Period age;


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


    public Person(Name name, BirthDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person() {
        this.name = new Name();
        this.birthDate = new BirthDate();
        this.age = Period.between(birthDate.localBirthDate, LocalDate.now());
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setBirthDate(BirthDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setAge(Period age) {
        this.age = age;
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



