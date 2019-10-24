package task2;

import java.util.ArrayList;
import java.util.List;

public class Hr {
    private ArrayList <Person> candidates = new ArrayList<>();

    public List<Person> examinePerson(Person person) {
        if (person.getSkills().contains(Skills.AnswerThePhone) && person.getSkills().contains(Skills.MakeCoffe) && person.getSkills().contains(Skills.DocumentArchiving))
            candidates.add(person);

        return candidates;
    }
}
