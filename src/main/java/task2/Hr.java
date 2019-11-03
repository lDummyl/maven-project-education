package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hr {
    private ArrayList <Person> candidates = new ArrayList<>();

    public List<Person> examinePerson(Person person) {

        if (Arrays.toString(person.getClass().getInterfaces()).contains("CanPassInterview")) // TODO: 11/3/19 не самый лучший способ использования интерфейсов
            candidates.add(person);
        return candidates;
    }
}
