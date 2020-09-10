package task1;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        first();
        second();

    }

    public static void first() {
    }

    public static void second() {
        PersonsProcessor generator = new PersonsProcessor();
        // TODO: 9/10/20 сделай так чтобы все созданные 100к человек были уникальны
        ArrayList<Person> list = (ArrayList<Person>) generator.generatePersons(100000).clone();
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

