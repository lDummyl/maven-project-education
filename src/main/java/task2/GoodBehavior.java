package task2;

import task1.Person;

import java.util.HashSet;
import java.util.Random;

public abstract class GoodBehavior implements Behavior {
    public final int numberOfStaff = 20;
    Random random = new Random();


    @Override
    public HashSet<Person> goodBehavior() {
        HashSet<Person> set = (HashSet<Person>) new Hr("").selectedPeople(random.nextInt(numberOfStaff));
        return set;
    }


}
