package newTask1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import task4.JsonReady;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@JsonAutoDetect
public class Person implements Comparable<Person>, JsonReady {
    private final Name name;
    private final BirthDate birthDate;
    private Integer age;

    public Person(String firstName, String lastName, int year, int month, int day) {
        this.name = new Name(firstName, lastName);
        this.birthDate = new BirthDate(year, month, day);
        this.age = Period.between(this.birthDate.getLocalBirthDate(), LocalDate.now()).getYears();
        this.age = Period.between(this.birthDate.getLocalBirthDate(), LocalDate.now()).getYears();
    }

    public Person() {
        this.name = new Name();
        this.birthDate = new BirthDate();
        this.age = Period.between(this.birthDate.getLocalBirthDate(), LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public BirthDate getBirthDate() {
        return birthDate;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(birthDate, person.birthDate) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, age);
    }

    @Override
    public int compareTo(Person o) {
        return this.birthDate.getLocalBirthDate().compareTo(o.birthDate.getLocalBirthDate());
    }
}
