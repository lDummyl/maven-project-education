package task1;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        first();
        second();

    }

    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
//		Person person1 = new Person("Ben", 24);

        Name name = new Name("Ben");
        Age age = new Age(2010, 11, 5);
        Person person1 = new Person(name, age);
        Person person2 = new Person(new Name("Inna"), new Age(1998, 4, 14));
        Person person3 = new Person(new Name("Inna1"), new Age(1993, 3, 14));
        Person person4 = new Person(new Name("Inna2"), new Age(1993, 4, 14));

        ArrayList<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        Person oldest = list.get(0);
        for (Person person : list) {
            System.out.println(person);
            if (person.isOlderThan(oldest)) {
                oldest = person;
            }

        }

        System.out.println("Старший это - " + oldest);
    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.


    }

}

class Name {

    String firstName;
    String lastName;

    public Name(String name) {
        firstName = name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

class Age {

    int year;
    int month;
    int day;

    public Age(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "Age{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

class Person {
    public Person(Name name, Age age) {
        this.name = name;
        this.age = age;
    }

    Name name;
    Age age;

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    public boolean isOlderThan(Person oldest) {
//		oldest 1900 this 1990
        if (oldest.age.year < age.year) {
            return false;
        } else{
            return true;
        }
    }
}