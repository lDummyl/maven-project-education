package task1;


import java.util.Date;

public class Main {

    public static void main(String[] args) {
        first();
        second();

    }

    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
        Person person = new Person("Иван Иванов", 20, 4, 1996);

        // TODO: 9/3/20 Hi there!

        System.out.println(person.name.firstName );
    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

    }

}

class Name {

    String firstName;
    String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class BirthDate {

    int year;
    int month;
    int day;


}

class Person {

    Name name;
    BirthDate birthDate;


    public Person(String name, int day, int month, int year) {
        String[] split = name.split(" ");

        this.name = new Name(split[0], split[1]);
    }
}