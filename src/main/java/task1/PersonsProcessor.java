package task1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class PersonsProcessor {
    public ArrayList<Person> generatePersons(int numberOfPerons) {
        Random random = new Random();
        String[] fnames = {"Иван", "Григорий", "Василий", "Эдди", "Сергей", "Александр", "Роланд", "Стивин", "Виктор", "Томас", "Айзек"};
        String[] lnames = {"Паршин", "Иванов", "Анхимов", "Быков", "Вихров", "Артёмов", "Фёдоров", "Аркадьев", "Гришин", "Хрусталёв", "Азимов"};

        HashSet<String> names = new HashSet<String>();
        ArrayList<String> namesArray = new ArrayList<>();

        while (names.size() < numberOfPerons) {
            names.add(fnames[random.nextInt(fnames.length)] + " " + lnames[random.nextInt(lnames.length)]);
        }
        namesArray.addAll(names);

        ArrayList<Person> persons = new ArrayList<>();
        ArrayList<LocalDate> dates = new ArrayList<>();

        while (dates.size() < numberOfPerons) {
            try {
                dates.add(LocalDate.of(random.nextInt(1 + 2019), random.nextInt(1 + 11), random.nextInt(1 + 30)));
            } catch (DateTimeException e) {
            }
        }

        for (int i = 0; i < numberOfPerons; i++) {
            persons.add(new Person(namesArray.get(i), dates.get(i)));
        }
        return persons;
    }

    public void oldestSearch(ArrayList<Person> list) {
        int oldest = 0;
        LocalDate min = list.get(0).localbirthDate;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).localbirthDate.isBefore(min)) {
                min = list.get(i).localbirthDate;
                oldest = i;
            }
        }
        System.out.println(list.get(oldest).name.firstName);
    }
}
