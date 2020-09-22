package CollectionWork;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Comparable<Person> {
    BirtDate birthDate;
    int age;
    static int i = 0;

    public Person() {

        this.birthDate = new BirtDate();
        System.out.println("Создан человек " + Person.i);
        Person.i++;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(birthDate, person.birthDate);
    }


    @Override
    public int hashCode() {
        return Objects.hash(birthDate, age);
    }


    @Override
    public int compareTo(Person o) {
        return this.birthDate.compareTo(o.birthDate);
    }
}
