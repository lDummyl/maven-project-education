package task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

public class PersonsProcessor {

    public TreeSet<Person> generatePersons(int numberOfPerons) {
        TreeSet<Person> persons = new TreeSet<>();

        for (int i = 0; i < 3000000; i++) {
            persons.add(new Person());
            System.out.println(persons.size());
        }
        return persons;
    }


    public void oldestSearch(TreeSet<Person> set) {
        System.out.println(set.first().birthDate.localBirthDate);
    }
    /*
    public void oldestSearchT(ArrayList<Human> list) {


        int oldest = 0;
        // TODO: 9/10/20 подумай насчет инкапсуляции и здесь, чтобы зделать код лаконичней и наглядней
        LocalDate min = list.get(0).birthDate.localBirthDate;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i).birthDate.localBirthDate.isBefore(min)) {
                min = list.get(i).birthDate.localBirthDate;
                oldest = i;

            }
        }
        System.out.println(list.get(oldest).birthDate.localBirthDate);
    }
    */
}