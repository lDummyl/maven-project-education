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
    }

    public static void second() {
        System.out.println(Person.CreatePerson(100));
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

    static class Person {
        String name;
        LocalDate birthDate;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.birthDate = LocalDate.of(year, month, day);
        }

        public static ArrayList<Person> CreatePerson(int numberofPersons){
            Random random = new Random();
            String[] fnames = {"Иван", "Григорий", "Василий", "Эдди", "Сергей", "Александр", "Роланд", "Стивин", "Виктор", "Томас", "Айзек"};
            String[] lnames = {"Паршин", "Иванов", "Анхимов", "Быков", "Вихров", "Артёмов", "Фёдоров", "Аркадьев", "Гришин", "Хрусталёв", "Азимов"};

            HashSet<String> names = new HashSet<String>();
            while (names.size() < numberofPersons) {
                names.add(fnames[random.nextInt(fnames.length)] + " " + lnames[random.nextInt(lnames.length)]);
            }
            ArrayList<Person> persons = new ArrayList<>();
            Iterator<String> itr = names.iterator();
            while (itr.hasNext()) {
                String name = itr.next();
                persons.add(new Person(name, 1 + random.nextInt(29), 1 + random.nextInt(11), 1 + random.nextInt(2020)));
            }
            return persons;
        }
    }
}