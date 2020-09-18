package task1.service;

import task1.model.BirthDate;
import task1.model.Name;
import task1.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PersonAnalyzer {

    private final Random r = new Random();

    public String getOldest(List<Person> list) {
        int indexOfOldest = 0;
        Person temp = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Person person = list.get(i);
            if (person.getBirthDate().getBirthday().compareTo(temp.getBirthDate().getBirthday()) < 0) {
                temp = person;
                indexOfOldest = i;
            }
        }
        return "The oldest one is: " + list.get(indexOfOldest).getName();
    }

    public List<Person> getRandomPersonsList(List<Name> names) {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
        Person person;
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            person = new Person();
            person.setName(names.get(r.nextInt(10)));
            person.setBirthDate(new BirthDate(LocalDate.ofEpochDay(randomDay)));
            personList.add(person);
        }
        return personList;
    }
}
