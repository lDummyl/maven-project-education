package task1.controller;

import task1.model.BirthDate;
import task1.model.Name;
import task1.model.Person;
import task1.util.NameGenerator;
import task1.util.PersonGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        PersonGenerator pg = new PersonGenerator();
        getOldest(pg.generate());
        NameGenerator ng = new NameGenerator();
        printRandomPersons(ng.generate());
    }

    public static void getOldest(List<Person> list) {
        int indexOfOldest = 0;
        Person temp = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Person person = list.get(i);
            if (person.getBirthDate().getBirthday().compareTo(temp.getBirthDate().getBirthday()) < 0) {
                temp = person;
                indexOfOldest = i;
            }
        }
        System.out.println("The oldest one is: " + list.get(indexOfOldest).getName());
    }

    public static void printRandomPersons(List<Name> names) {
        Random r = new Random();
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
        Person person;
        for (int i = 0; i < 10; i++) {
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            person = new Person();
            person.setName(names.get(r.nextInt(10)));
            person.setBirthDate(new BirthDate(LocalDate.ofEpochDay(randomDay)));
            System.out.println(person);
        }
    }

}

