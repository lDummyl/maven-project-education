package task1;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        first();
        second();

    }

    public static void first() {
    }

    public static void second() {
        PersonsProcessor generator = new PersonsProcessor();
        ArrayList<Person> list = (ArrayList<Person>) generator.generatePersons(1000000).clone();
        System.out.println(list.size());
        generator.oldestSearch(list);
    }

}

class Person {
    Name name;
    BirthDate birthDate;

    public Person(String name, BirthDate localbirthDate) {
        this.name = new Name(name);
        this.birthDate = localbirthDate;
    }

    public Person() {
        this.name = new Name();
        this.birthDate = new BirthDate();
    }
}

