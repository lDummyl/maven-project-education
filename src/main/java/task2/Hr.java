package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hr {
    private ArrayList <Person> candidates = new ArrayList<>();

    public List<Person> examinePerson(Person person) {
        if (Arrays.toString(person.getClass().getInterfaces()).contains("AnswerThePhone") && Arrays.toString(person.getClass().getInterfaces()).contains("DocumentArchiving") && Arrays.toString(person.getClass().getInterfaces()).contains("CanMakeCoffee"))
            candidates.add(person);
        return candidates;
    }
}
