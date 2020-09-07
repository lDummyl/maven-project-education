package task1;


import java.util.*;
import java.time.*;

public class Main {

    public static void main(String[] args) {

        first();
        second();

    }

    public static void first() {
    }

    public static void second() {
        PersonsProcessor generator = new PersonsProcessor();
        generator.generatePersons(100);
        ArrayList<Person> list = generator.generatePersons(100);
        generator.oldestSearch(list);

    }
}

class Name {
    String firstName;
    String lastName;

    public Name(String name) {
        String[] split = name.split(" ");
        this.firstName = split[0];
        this.lastName = split[1];
    }
}

class BirthDate {

    int year;
    int month;
    int day;

    public BirthDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}

class Person {
    Name name;
    LocalDate localbirthDate;

    //public Person(String name, int day, int month, int year) {
    //    this.birthDate = LocalDate.of(year, month, day);
    //     this.name = new Name(name);


    public Person(String name, LocalDate birthDate) {
        this.name = new Name(name);
        this.localbirthDate = birthDate;
    }
}

