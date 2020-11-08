package task2;

import task1.Person;

import java.util.Collection;
import java.util.TreeSet;

public class ChiefGuard extends Guard{
    public ChiefGuard(Person person) {
        super(person);
    }

    public ChiefGuard(Guard guard) {
        super(guard);
    }

    public Guard chooseGuard(Collection<Guard> guards){
        TreeSet<Guard> guards1 = new TreeSet<>();
        return guards1.first();
    }

    public void dismissGuard(Guard guard){
        guard = null;
    }
}
