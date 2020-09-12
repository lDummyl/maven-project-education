package task1.util;

import task1.model.BirthDate;
import task1.model.Name;
import task1.model.Person;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PersonGenerator implements Generator<Person> {

    public List<Person> generate() {
        Person p1 = new Person(new Name("Dmitry", "Sheykin"), new BirthDate(LocalDate.of(1992, 9, 14)));
        Person p2 = new Person(new Name("Alexey", "Alexeev"), new BirthDate(LocalDate.of(1990, 10, 10)));
        Person p3 = new Person(new Name("Ivan", "Ivanov"), new BirthDate(LocalDate.of(1985, 7, 19)));
        Person p4 = new Person(new Name("Sergey", "Sergeev"), new BirthDate(LocalDate.of(1982, 5, 25)));
        Person p5 = new Person(new Name("Kirill", "Kirillov"), new BirthDate(LocalDate.of(1999, 1, 28)));
        return Arrays.asList(p1, p2, p3, p4, p5);
    }
}
