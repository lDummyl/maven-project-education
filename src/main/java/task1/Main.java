package task1;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
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
        ArrayList<Person> list = (ArrayList<Person>) generator.generatePersons(100).clone();
        System.out.println(list.size());
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

    public Person(String name, LocalDate localbirthDate) {
        this.name = new Name(name);
        this.localbirthDate = localbirthDate;
    }
}

