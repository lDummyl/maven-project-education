package task1;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        first();
        second();

    }

    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
        Person[] person = new Person[]
                {
                        new Person(new Name("Anton", "Sivochalov"), new BirthDate(15, 1, 65)),
                        new Person(new Name("Artem", "Verenitcin"), new BirthDate(45, 65, 45)),
                        new Person(new Name("Alexandr", "Dubchenko"), new BirthDate(45, 65, 984)),
                        new Person(new Name("Alexandr", "Beloborodov"), new BirthDate(45, 65, 123)),
                        new Person(new Name("Alexandr", "Terehov"), new BirthDate(45, 65, 21))
                };
        Calendar firstDayOfBerth = person[0].birthDate.dayOfBerth;
        Name oldest = person[0].name;
        for (Person p : person) {
            if (p.birthDate.dayOfBerth.before(firstDayOfBerth)) {
                firstDayOfBerth = p.birthDate.dayOfBerth;
                oldest = p.name;
            }
        }
        System.out.println("The oldest man is " + oldest.firstName + " " + oldest.lastName + ".");
    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.
//		Person [] person = new Person[10];

        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Name name = new Name();
            BirthDate birthDate = new BirthDate();
            Person person = new Person(name, birthDate);
            people.add(person);
        }
        System.out.println(people);
        // TODO: 26.06.2020 print oldest person

//        for (Person p : person) {
////            p = new Person(new Name("Alexandr", "Terehov"), new Age(45, 65, 21));
//            //new Person()
//            p.name.firstName = firstNames.get(new Random().nextInt(6));
//            p.name.lastName = lastNames.get(new Random().nextInt(6));
//            p.age.day = new Random().nextInt(32);
//            p.age.month = new Random().nextInt(12);
//            p.age.year = new Random().nextInt(120);
//            System.out.println(p.name.firstName + " " + p.name.lastName + " is " + p.age.year + " years " + p.age.month + " months " + p.age.day + " days.");
//        }
    }
}

class Name {
    static ArrayList<String> firstNames = new ArrayList<>();
    static ArrayList<String> lastNames = new ArrayList<>();

    static {
        firstNames.add(0, "Anton");
        firstNames.add(1, "Artem");
        firstNames.add(2, "Alexandr");
        firstNames.add(3, "Vladislav");
        firstNames.add(4, "Sergey");
        firstNames.add(5, "Alexey");
    }

    static {
        lastNames.add(0, "Sivochalov");
        lastNames.add(1, "Verenitcin");
        lastNames.add(2, "Strelka");
        lastNames.add(3, "Dubchenko");
        lastNames.add(4, "Beloborodov");
        lastNames.add(5, "Terehov");
    }

    String firstName;
    String lastName;

    public Name() {
        Random random = new Random();
        this.firstName = firstNames.get(random.nextInt(firstNames.size()));
        this.lastName = lastNames.get(random.nextInt(lastNames.size()));
    }

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class BirthDate {

    private static final int MAX_PERSON_AGE = 120;
    private static final int MONTHS_IN_YEAR = 11;
    public static final int DAYS_IN_MONTH = 30; // TODO: 26.06.2020 apply month relation

    int year;
    int month;
    int day;
    Calendar dayOfBerth = new GregorianCalendar();
    private LocalDate localBirthdate;

    public BirthDate() {
        Random random = new Random();
        localBirthdate = LocalDate.of(1900 + random.nextInt(MAX_PERSON_AGE), 1 + random.nextInt(MONTHS_IN_YEAR), 1 + random.nextInt(DAYS_IN_MONTH));

    }

    BirthDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        dayOfBerth.add(Calendar.YEAR, -year);
        dayOfBerth.add(Calendar.MONTH, -month);
        dayOfBerth.add(Calendar.DAY_OF_MONTH, -day);
    }
}

class Person {

    Name name;
    BirthDate birthDate;

    Person(Name name, BirthDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

}