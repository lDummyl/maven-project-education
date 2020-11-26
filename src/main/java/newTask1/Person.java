package newTask1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person implements Comparable<Person>{
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
