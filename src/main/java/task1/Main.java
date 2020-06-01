package task1;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // TODO: 5/22/20 приведи этот класс в соответствие с SRP, и переиспользуй во второй задаче(переносить не обязательно, public дает межпакетный доступ)
    public static void main(String[] args) {
//        new Main().first();
        new Main().second();
    }

    public void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
        List<Person> listPersons = getPersons();
        // TODO: 5/24/20 куда то пропали классы Name BirthDate может в VCS не попали.
        letsSeeOldestPerson(listPersons);
    }

    public ArrayList<Person> getPersons() {
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < Name.getNames().size() && i < BirthDate.getBirthDates().size(); i++) {
            people.add(new Person(Name.getNames().get(i), BirthDate.getBirthDates().get(i)));
        }
        return people;
    }

    public void letsSeeOldestPerson(List<Person> listPersons) {
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
        System.out.println(listPersons.get(number).name + "\n");
    }

    public void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

        // TODO: 5/25/20 Что ж посмотрим как хорошо приложение массшатбируется. Попробуем создать поселочек на 10 000 человек(не меньше и не больше).
        //  Все они должны быть уникальными сочетанию ФИО + дате рождения. Имена и фамилии без цифр, обычные человеческие. Возраст от начала 1900 года.
        //  Ну и определим старшего для смеха.


        PersonProvider personProvider = new PersonProvider();
        List<Person> list = new ArrayList<>(personProvider.getPersons(10));
        Person oldest = findOldest(list);
        System.out.println("oldest = " + oldest);
    }

    private Person findOldestPerson(Map<Name, BirthDate> map) {
        List<Person> people = pairsToPersons(map);
        return findOldest(people);
    }

    private Person findOldest(List<Person> people) {
        // TODO: 13.05.2020 implement
        Person oldest = people.get(0);
        for (Person person : people) {
            if (oldest.isYounferThan(person)) {
                oldest = person;
            }
        }
        return oldest;
    }

    private List<Person> pairsToPersons(Map<Name, BirthDate> map) {
        // TODO: 13.05.2020 implement
        return map.entrySet().stream()
                .map(e -> new Person(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public void logPairs(Map<Name, BirthDate> map) {
        for (Map.Entry<Name, BirthDate> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    private Map<Name, BirthDate> getMap(List<BirthDate> listBirthDates, List<Name> listNames) {
        HashMap<Name, BirthDate> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(listNames.get(new Random().nextInt(7)), listBirthDates.get(new Random().nextInt(7)));
        }
        return map;
    }

}

// TODO: 13.05.2020 YAGNI

