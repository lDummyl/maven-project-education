package task2;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Director  {

    // TODO: 5/22/20 не и спользуй статические методы
    public Person firstFinalChoice() {
        List<Person> list = new Secretary(null,null).getPersons();
        final int luckyChoice = new Random().nextInt(list.size());
        return list.get(luckyChoice);
    }


    public long age(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        long exp = ChronoUnit.YEARS.between(birthday, LocalDate.now());
        return exp;
    }


    public boolean samePerson(Person p, Person p1) {
        if (p.birthDate.year == p1.birthDate.year && p.birthDate.month == p1.birthDate.month &&
                p.birthDate.day == p1.birthDate.day) {
            return true;
        } else return false;
    }


    public List<Person> getPersonsWhoAreGraduatedUniversity() {
        List<Person> graduatedUniversity = new ArrayList<>();
       OUTER_LOOP: for (Person p : new Hr().chooseSecretary()
        ) {
            long ageOfPerson = age(p.birthDate.year, p.birthDate.month, p.birthDate.day);
            if (ageOfPerson > 21 && !samePerson(p, Office.firstHiredHuman)) {
                graduatedUniversity.add(p);
            }
        }

        if (checkLength(graduatedUniversity)==true) return graduatedUniversity;
        else return getPersonsWhoAreGraduatedUniversity();
    }

    public boolean checkLength(List list){
        if (list.size()>0) return true;
        else return false;
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


    public Person secondFinalChoice() {
        int choice = 0;
//        System.out.println("Director 2: Hmmm... Lets make the second choice!/n Who are the most experienced?");
        Map<Integer, Person> map = changeExperience();
        for (Map.Entry<Integer, Person> personEntry : map.entrySet()) {
            if (choice < personEntry.getKey()) {
                choice = personEntry.getKey();
            }
//            System.out.printf("Experience %d years, name %s\n", personEntry.getKey(), personEntry.getValue());
        }
//        System.out.println("Most experience is " + choice + " years");
        return map.get(choice);
    }

    public static void main(String[] args) {
        Director firstDirector = new Director();
        firstDirector.firstFinalChoice();
        Director secondDirector = new Director();
        secondDirector.secondFinalChoice();
    }
}
