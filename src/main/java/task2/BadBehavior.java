package task2;

import task1.Person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

// TODO: 6/3/20 все не правильно, интерфейс совсем не так используется.
public abstract class BadBehavior implements Behavior {
    public int numberOfStaff = 20;
    Random random = new Random();
    HashSet<Person> set;

    @Override
    public HashSet<Person> badBehavior() {
        set = (HashSet<Person>) new Hr("").selectedPeople(1 + random.nextInt(numberOfStaff));
        casting();
        return set;
    }

    public void casting() {
        int a = 3;
        while (a > 0) {
            set = (HashSet<Person>) new Hr("").selectedPeople(1);
            System.out.println("Those people weren't good! I need a new list!!");
            a--;
        }
    }

//    public long age(int year, int month, int day) {
//        LocalDate birthday = LocalDate.of(year, month, day);
//        long exp = ChronoUnit.YEARS.between(birthday, LocalDate.now());
//        return exp;
//    }

}
