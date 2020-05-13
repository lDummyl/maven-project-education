package task1;

import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
//        first();
        second();
    }

    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
        List<Person> listPersons = new ArrayList<>();
        Person person = new Person(new Name("Vasily", "S"), new BirthDate(1989, 11, 11));
        Person person2 = new Person(new Name("Ivan", "K"), new BirthDate(2010, 11, 5));
        Person person3 = new Person(new Name("Sergey", "M"), new BirthDate(1980, 9, 2));
        Person person4 = new Person(new Name("Nina", "I"), new BirthDate(1984, 3, 5));
        Person person5 = new Person(new Name("Masha", "O"), new BirthDate(1990, 6, 7));
        listPersons.add(person);
        listPersons.add(person2);
        listPersons.add(person3);
        listPersons.add(person4);
        listPersons.add(person5);

        LocalDate date = LocalDate.now();
        int number = 0;

        for (int i = 0; i < listPersons.size(); i++) {
            LocalDate localDateComparable = LocalDate.of(listPersons.get(i).birthDate.year, listPersons.get(i).birthDate.month, listPersons.get(i).birthDate.day);
            if (date.isBefore(localDateComparable)) {
                date = date;
            } else {
                date = localDateComparable;
                number = i;
            }
        }
        System.out.println(listPersons.get(number).name);
        System.out.println();
    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.
        List<BirthDate> listBirthDates = getAges();
        List<Name> listNames = getNames();
        Map<Name, BirthDate> map = getMap(listBirthDates, listNames);
        logPairs(map);
        Person oldest = findOldestPerson(map);
        System.out.println("oldest = " + oldest);
    }

    private static Person findOldestPerson(Map<Name, BirthDate> map) {
        List<Person> people = pairsToPersons(map);
        return findOldest(people);
    }

    private static Person findOldest(List<Person> people) {
        // TODO: 13.05.2020 implement
        Person oldest = people.get(0);
        for (Person person : people) {
            if (oldest.isYounferThan(person)) {
                oldest = person;
            }
        }
        return oldest;
    }

    private static List<Person> pairsToPersons(Map<Name, BirthDate> map) {
        // TODO: 13.05.2020 implement
        return map.entrySet().stream()
                .map(e -> new Person(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    private static void logPairs(Map<Name, BirthDate> map) {
        for (Map.Entry<Name, BirthDate> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    private static Map<Name, BirthDate> getMap(List<BirthDate> listBirthDates, List<Name> listNames) {
        HashMap<Name, BirthDate> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(listNames.get(new Random().nextInt(7)), listBirthDates.get(new Random().nextInt(7)));
        }
        return map;
    }

    private static List<Name> getNames() {
        List<Name> listNames;
        listNames = new ArrayList<Name>();
        listNames.add(new Name("Nina", "I"));
        listNames.add(new Name("Masha", "O"));
        listNames.add(new Name("Sergey", "M"));
        listNames.add(new Name("Ivan", "K"));
        listNames.add(new Name("Vasily", "S"));
        listNames.add(new Name("Ruslan", "Z"));
        listNames.add(new Name("Irina", "P"));
        listNames.add(new Name("Tanya", "E"));
        return listNames;
    }

    private static List<BirthDate> getAges() {
        List<BirthDate> listBirthDates;
        listBirthDates = new ArrayList<BirthDate>();
        listBirthDates.add(new BirthDate(2010, 11, 5));
        listBirthDates.add(new BirthDate(1989, 5, 11));
        listBirthDates.add(new BirthDate(1980, 9, 2));
        listBirthDates.add(new BirthDate(1984, 3, 5));
        listBirthDates.add(new BirthDate(1990, 6, 7));
        listBirthDates.add(new BirthDate(1999, 7, 1));
        listBirthDates.add(new BirthDate(2002, 8, 2));
        listBirthDates.add(new BirthDate(2000, 1, 17));
        return listBirthDates;
    }

}

// TODO: 13.05.2020 YAGNI
class Name {

    String firstName;
    String lastName;

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'';
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

//dto
@ToString
class BirthDate {

    int year;
    int month;
    int day;


    public BirthDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public LocalDate toLocalDate() {
        return LocalDate.of(year, month, day);
    }
}

