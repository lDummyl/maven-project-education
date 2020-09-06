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
        Generator generator = new Generator();
        ArrayList<Person> list = (ArrayList<Person>)generator.generatePersons(100).clone();
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).name.firstName);
        }
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

class Person {
    Name name;
    LocalDate birthDate;
    public Person(String name, int day, int month, int year) {
        String[] split = name.split(" ");
        this.birthDate = LocalDate.of(year, month, day);
        this.name = new Name(name);
    }
}
class Generator {
    public ArrayList<Person> generatePersons(int numberOfPerons) {
        Random random = new Random();
        String[] fnames = {"Иван", "Григорий", "Василий", "Эдди", "Сергей", "Александр", "Роланд", "Стивин", "Виктор", "Томас", "Айзек"};
        String[] lnames = {"Паршин", "Иванов", "Анхимов", "Быков", "Вихров", "Артёмов", "Фёдоров", "Аркадьев", "Гришин", "Хрусталёв", "Азимов"};

        HashSet<String> names = new HashSet<String>();
        while (names.size() < numberOfPerons) {
            names.add(fnames[random.nextInt(fnames.length)] + " " + lnames[random.nextInt(lnames.length)]);
        }
        ArrayList<Person> persons = new ArrayList<>();
        Iterator<String> itr = names.iterator();
        while (itr.hasNext()) {
            String name = itr.next();
            persons.add(new Person(name, 1 + random.nextInt(30), 1 + random.nextInt(11), 1 + random.nextInt(2020)));
        }
        return persons;
    }
}