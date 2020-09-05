package task1;


import java.time.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;


public class Main {

    public static void main(String[] args) {

        first();
        second();

    }

    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего

        int oldest = 0;


        Person person = new Person("Иван Иванов", 20, 11, 1945);
        Person person2 = new Person("Григорий Зуев", 14, 4, 1911);
        Person person3 = new Person("Степан Трешков", 4, 8, 1993);
        Person person4 = new Person("Виктор Триванов", 10, 6, 1964);
        Person person5 = new Person("Ник Теренов", 10, 6, 1911);

        ArrayList<Person> list = new ArrayList<Person>();
        list.add(person);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);

        // TODO: 9/5/20 как я сказал нужно переиспользовать поиск во второй части и желательно чтобы он был лаконичней, сильно лаконичней
        LocalDate min = LocalDate.of(list.get(0).birthDate.year, list.get(0).birthDate.month, list.get(0).birthDate.day);

        for (int i = 0; i < list.size(); i++) {
            if (LocalDate.of(list.get(i).birthDate.year, list.get(i).birthDate.month, list.get(i).birthDate.day).isBefore(min)) {
                min = LocalDate.of(list.get(i).birthDate.year, list.get(i).birthDate.month, list.get(i).birthDate.day);
                oldest = i;
            }
        }
        System.out.println(list.get(oldest).name.firstName);
    }


    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

        // TODO: 9/4/20  тот тоже стоит найти имя старшего, баз копипасты и что касается имен, пусть теперь будет 100 человек
        //  у каждого уникальное сочетание имя-фамилия
        Random random = new Random();
        String[] fnames = {"Иван", "Григорий", "Василий", "Эдди", "Сергей", "Александр", "Роланд", "Стивин", "Виктор", "Томас", "Айзек"};
        String[] lnames = {"Паршин", "Иванов", "Анхимов", "Быков", "Вихров", "Артёмов", "Фёдоров", "Аркадьев", "Гришин", "Хрусталёв", "Азимов"};

        HashSet<String> names = new HashSet<String>();
        while (names.size() < 100) {
            names.add(fnames[random.nextInt(fnames.length)] + " " + lnames[random.nextInt(lnames.length)]);
        }

        ArrayList<Person> persons = new ArrayList<>();
        Iterator<String> itr = names.iterator();
        while (itr.hasNext()) {
            String elem = itr.next();
            persons.add(new Person(elem, 1 + random.nextInt(30), 1 + random.nextInt(11), 1 + random.nextInt(2020)));
        }
        Person.oldestPerson(persons);
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

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
    public Person(Name name, int day, int month, int year) {
        this.name = name;
        this.birthDate = new BirthDate(year, month, day);
    }

    Name name;
    BirthDate birthDate;


    public Person(String name, int day, int month, int year) {
        String[] split = name.split(" ");
        this.birthDate = new BirthDate(year, month, day); //Не в правильном порядке передавались параметры в birthdate
        this.name = new Name(split[0], split[1]);
    }

    public static void oldestPerson(ArrayList<Person> list) {
        int oldest = 0;
        LocalDate min = LocalDate.of(list.get(0).birthDate.year, list.get(0).birthDate.month, list.get(0).birthDate.day);

        for (int i = 0; i < list.size(); i++) {
            if (LocalDate.of(list.get(i).birthDate.year, list.get(i).birthDate.month, list.get(i).birthDate.day).isBefore(min)) {
                min = LocalDate.of(list.get(i).birthDate.year, list.get(i).birthDate.month, list.get(i).birthDate.day);
                oldest = i;
            }
        }
        System.out.println(list.get(oldest).name.firstName);
    }

}