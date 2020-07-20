package task1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // TODO: 7/15/20 hi from outside
        first();
        second();

    }


    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
        ArrayList<Person> people = new ArrayList<>();


        Person иванПетров = new Person("Иван Петров", 13, 8, 1956);
        people.add(иванПетров);
        people.add(new Person("Иван Иванов", 12, 5, 1985));
        people.add(new Person("Иван Иванов", 12, 5, 1915));

        Person oldestPerson = people.get(0);
        for (Person person : people) {
            boolean answer = oldestPerson.isOlderThan(person);
            if (!answer) {
                oldestPerson = person;
            }
        }
        //System.out.println(oldestPerson.birthDate.year);


    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

        int count = 100;
        while (count > 0) {
            System.out.println(new Person(new Name(), new BirthDate()));
            count--;
        }
	    // TODO: 7/20/20 тоже не помешает найти старшего
    }

}

// TODO: 7/20/20 эти классы можно вынести в отдельные фаилы, если добавить к классу publicон покраснеет от стыда и через alt+ent редактор автоматически сделает это за тебя


class Name {

    String firstName;
    String lastName;


    private static final ArrayList<String> firstNames = new ArrayList<>();
    private static final ArrayList<String> lastNames = new ArrayList<>();
    private Random randomNumber;


    static {
        firstNames.add("Ivan");
        firstNames.add("Andrey");
        firstNames.add("Petr");
        firstNames.add("Evgeny");

        lastNames.add("Ivanov");
        lastNames.add("Petrov");
        lastNames.add("Andreev");
        lastNames.add("Sidorov");

    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name() {
        try {
            randomNumber = SecureRandom.getInstanceStrong(); // TODO: 7/20/20 тогда уж это тоже в статическом поле лучше проинициализировать 1 раз чем 100
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        getRandomName();
    }

    private Name getRandomName() {
        this.firstName = firstNames.get(randomNumber.nextInt(firstNames.size()));
        this.lastName = lastNames.get(randomNumber.nextInt(lastNames.size()));
        return this;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName + ' ';
    }
}


class BirthDate {

    int year;
    int month;
    int day;
    LocalDate localDate;
    private Random randomNumber;

    public BirthDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.localDate = LocalDate.of(year, month, day);
    }

    public boolean earlyThan(BirthDate birthDate) {
        return this.localDate.isBefore(birthDate.localDate);
    }

    public BirthDate() {
        try {
            this.randomNumber = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        getRandomDate();
    }

    private BirthDate getRandomDate() {
        this.day = randomNumber.nextInt(30) + 1;
        this.month = randomNumber.nextInt(11) + 1;
        this.year = randomNumber.nextInt(110) + 1910; // TODO: 7/20/20 это называется magic numbers их заменяют константы
        try {
            this.localDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            this.localDate = LocalDate.of(year, month, day - 3); // TODO: 7/20/20 элегантный, но костыль
        }
        return this;
    }

    @Override
    public String toString() {
        return localDate + "";
    }
}


class Person {

    Name name;
    BirthDate birthDate;


    public Person(String name, int day, int month, int year) {
        birthDate = new BirthDate(day, month, year);
        // TODO: 15.07.2020 implement
    }

    public Person(Name name, BirthDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public boolean isOlderThan(Person person) {
        return this.birthDate.earlyThan(person.birthDate);
    }

    @Override
    public String toString() {
        return name + " " + birthDate;
    }
}