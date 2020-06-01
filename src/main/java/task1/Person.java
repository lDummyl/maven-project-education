package task1;

import java.util.Objects;

public class Person {

    Name name;
    BirthDate birthDate;

    public Person(Name name, BirthDate age) {
        // TODO: 5/21/20 o_0 !?!
        this.name = name;
        this.birthDate = age;
    }


    @Override
    public String toString() {
        return "firstName='" + name.firstName + '\'' +
                ", lastName='" + name.lastName + '\'' +
                ", age=" + birthDate.year + " " + birthDate.month + " " + birthDate.day + '\'';
    }


    public boolean isYounferThan(Person person) {
        return this.birthDate.toLocalDate().isAfter(person.birthDate.toLocalDate());
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
