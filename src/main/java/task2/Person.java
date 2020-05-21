package task2;

import java.time.LocalDate;
import java.util.Objects;

// TODO: 5/21/20 никто не запрещает переиспользовать уже созданные классы, наоборот это крайне приветствуется
public class Person {

    public Name name;
    public BirthDate birthDate;

    public Person(Name name, BirthDate age) {
        this.name =  name;
        this.birthDate = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", birthDate=" + birthDate +
                '}';
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
