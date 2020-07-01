package task1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // TODO: 6/26/20 Hi from outside  - Привет из вне? - не понимаю перевод ((
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
        // TODO: 7/1/20 это называется ссылка на метод. В бонусном пакете есть класс Lambda, можешь его разобрать чтобы понять как это работает.
        people.sort(Person::compareTo); // Почему список отсортировывается
        System.out.print(people.get(0));
        System.out.println(". He is the oldest man");
        // TODO: 26.06.2020 print oldest person
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

    int year;
    int month;
    int day;
    Calendar dayOfBerth = new GregorianCalendar();
    LocalDate localBirthdate;
    private int monthOfBirth;
    private int dayInMonth;
    //final int dayInMonth = 30; TODO: 26.06.2020 apply month relation - Если я сделал ТУДУ, то я могу их удалять?

    public BirthDate() {
        Random random = new Random();
        monthOfBirth = 1 + random.nextInt(MONTHS_IN_YEAR);
        if (monthOfBirth == 2) {
            dayInMonth = 1 + random.nextInt(27); // TODO: 7/1/20 ну все равно не правильно, а высокосный год? Не запаривайся всегда есть чем заняться и нужно правильно делать допущения.
        } else {
            if (monthOfBirth % 2 == 0) {
                dayInMonth = 1 + random.nextInt(29);
            } else {
                dayInMonth = 1 + random.nextInt(30);
            }
        }
        // TODO: 7/1/20 но если сильно хочется вот как это сделать проще
        boolean done = false;
        while (!done) {
            try {
                localBirthdate = LocalDate.of(1900 + random.nextInt(MAX_PERSON_AGE), monthOfBirth, dayInMonth);
                done = true;
            } catch (DateTimeException e) {
                System.err.println("Incorrect date:" + e.getMessage());
            }
        }
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

class Person implements Comparable<Person> {

    Name name;
    BirthDate birthDate;

    Person(Name name, BirthDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public int compareTo(Person person) {
        return (this.birthDate.localBirthdate.compareTo(person.birthDate.localBirthdate));
    }

    @Override
    public String toString() {
        return ('\n' + name.firstName + " " + name.lastName + " was born in " + birthDate.localBirthdate);
    }
}