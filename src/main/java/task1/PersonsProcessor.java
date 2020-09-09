package task1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class PersonsProcessor {
    public ArrayList<Person> generatePersons(int numberOfPerons) {
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            persons.add(new Person());
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
