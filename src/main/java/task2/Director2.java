package task2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.*;

// TODO: 5/21/20 ответ не верный, чтобы сделать разных директоров не обязательно делать разные классы. Ты же не делаешь классы PesonIvan, PersonNikolai
public class Director2 {

    public long age(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        long exp = ChronoUnit.YEARS.between(birthday, LocalDate.now());
        return exp;
    }


    public boolean compare(Person p, Person p1) {
        if (p.birthDate.year == p1.birthDate.year && p.birthDate.day == p1.birthDate.day &&
                p.birthDate.day == p1.birthDate.day) {
            return true;
        } else return false;
    }

    public List<Person> getPersonsWhoAreGraduatedUniversity() {
        List<Person> graduatedUniversity = new ArrayList<>();
        for (Person p : new Hr().chooseSecretary()
        ) {
            long ageOfPerson = age(p.birthDate.year, p.birthDate.month, p.birthDate.day);
            if (ageOfPerson > 21 && !compare(p, Office.firstHiredHuman)) {
                graduatedUniversity.add(p);
            }
        }
        return graduatedUniversity;
    }


    public Map<Integer, Person> changeExperience() {
        Random random = new Random();
        Map<Integer, Person> topPersons = new TreeMap<>();
        List<Person> list = getPersonsWhoAreGraduatedUniversity();
        for (Person p : list
        ) {
            long age = age(p.birthDate.year, p.birthDate.month, p.birthDate.day);
            topPersons.put(random.nextInt((int) age - 21), p);
        }
        return topPersons;
    }


    public Person finalChoose() {
        int choice = 0;
        Map<Integer, Person> map = changeExperience();
        for (Map.Entry<Integer, Person> personEntry : map.entrySet()) {
            if (choice < personEntry.getKey()) {
                choice = personEntry.getKey();
            }
            System.out.printf("Experience %d years, name %s\n", personEntry.getKey(), personEntry.getValue());
        }
        System.out.println("Most experience is " + choice + " years");
        return map.get(choice);
    }

    public static void main(String[] args) {
        new Director2().finalChoose();
    }
}


