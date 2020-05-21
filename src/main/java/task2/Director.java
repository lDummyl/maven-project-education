package task2;

import java.util.List;
import java.util.Random;

public class Director {
    public static Person finalChoose() {
        List<Person> list = Secretary.getPersons();
        final int luckyChoice = new Random().nextInt(list.size());
        return list.get(luckyChoice);
    }
}
