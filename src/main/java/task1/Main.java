package task1;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        first();
        second();


    }

    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(new Name("Fedor", "Ivanov"), new Age(15, 1, 1967)));
        personList.add(new Person(new Name("Egor", "Smirnov"), new Age(23, 9, 1952)));
        personList.add(new Person(new Name("Vadim", "Petrov"), new Age(1, 12, 1999)));
        personList.add(new Person(new Name("Semen", "Sidorov"), new Age(30, 5, 2016)));
        personList.add(new Person(new Name("Igor", "Petrenko"), new Age(7, 7, 1963)));


        List<Calendar> calendars = new ArrayList<>();


        for (int i = 0; i < personList.size(); i++) {
            calendars.add(new GregorianCalendar(personList.get(i).getAge().getYear(),
                    personList.get(i).getAge().getMonth() - 1,
                    personList.get(i).getAge().getDay()));
        }
        int old = 0;
        for (int i = 0; i < calendars.size() - 1; i++) {
            int compare = calendars.get(old).compareTo(calendars.get(i + 1));
            if (compare == 1) {
                old = i + 1;
            }
        }
        System.out.println(personList.get(old).getName().getFirstName() + " " + personList.get(old).getName().getLastName());

    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.
        List<String> firstN = new ArrayList<>();
        firstN.add("Ivan");
        firstN.add("Oleg");
        firstN.add("Nikita");
        firstN.add("Roman");
        firstN.add("Nikolay");
        firstN.add("Dmitry");
        firstN.add("Alexander");
        firstN.add("Stanislav");
        firstN.add("Konstantin");
        firstN.add("Sergey");

        List<String> lastN = new ArrayList<>();
        lastN.add("Ivanov");
        lastN.add("Smirnov");
        lastN.add("Sidorov");
        lastN.add("Petrov");
        lastN.add("Vodkin");
        lastN.add("Nikitin");
        lastN.add("Orlov");
        lastN.add("Kruglov");
        lastN.add("Jiglov");
        lastN.add("Djigurda");

        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            System.out.println(new Person(new Name(firstN.get(random.nextInt(10)), lastN.get(random.nextInt(10))), new Age(random.nextInt(30) + 1, random.nextInt(12) + 1, random.nextInt(80) + 1940)));
        }

    }

}

class Name {

    String firstName;
    String lastName;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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