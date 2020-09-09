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
        ArrayList<Person> list = (ArrayList<Person>) generator.generatePersons(100).clone();
        System.out.println(list.size());
        generator.oldestSearch(list);

    }
}

class Person {
    Name name;
    LocalDate localbirthDate;
    BirthDate birthDate;

    public Person(String name, LocalDate localbirthDate) {
        this.name = new Name(name);
        this.localbirthDate = localbirthDate;
    }

    public Person() {
        this.birthDate=new BirthDate();
        this.name = new Name();
    }
}

