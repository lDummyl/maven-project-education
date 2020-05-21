package task1;


import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

// TODO: 5/20/20 для начала я бы тут порядок навел
public class Main {

    public static void main(String[] args) {
        first();
        second();
    }

    public static Person searchOldest(List<Person> people) {
        Person oldest = people.get(0);
        for (Person person : people) {
            if (getDate(person.age).before(getDate(oldest.age))) {
                oldest = person;
            }
        }
        return oldest;
    }

    private static Date getDate(Age age) {
        return new Date(age.getYear(), age.getMonth() - 1, age.getDay());
    }

    public static void first() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(new Name("Fedor", "Ivanov"), new Age(15, 1, 1967)));
        personList.add(new Person(new Name("Egor", "Smirnov"), new Age(23, 9, 1952)));
        personList.add(new Person(new Name("Vadim", "Petrov"), new Age(1, 12, 1999)));
        personList.add(new Person(new Name("Semen", "Sidorov"), new Age(30, 5, 2016)));
        personList.add(new Person(new Name("Igor", "Petrenko"), new Age(7, 7, 1963)));

        System.out.println(searchOldest(personList));

    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

        PersonProvider personProvider = new PersonProvider();
        List<Person> personList = personProvider.getSomePerson(20);
        Person oldest = searchOldest(personList);
        System.out.println(oldest);
    }
}

class Name {

    String firstName;
    String lastName;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

class Age {

    int year;
    int month;
    int day;

    Age(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }
}

class Person {

    Name name;
    Age age;

    Person(Name name, Age age) {
        this.name = name;
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }
}