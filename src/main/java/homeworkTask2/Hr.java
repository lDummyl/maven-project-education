package homeworkTask2;

import java.util.ArrayList;
import java.util.List;

public class Hr extends Person{
    public Hr(Name name, Age age) {
        super(name, age);
    }
    public Hr(Person person)
    {
        super(person.name, person.age);
    }

    ArrayList <Person> candidates = new ArrayList<>();
    public List invite (Object human)
    {
        if (human instanceof Secretary)
        {
            Secretary secretary = (Secretary) human;
            if (secretary.interview())
            {
                candidates.add(secretary);
            }
            return candidates;
        }
        if (human instanceof Accountant)
        {
            Accountant accountant = (Accountant) human;
            if (accountant.interview())
            {
                candidates.add(accountant);
            }
            return candidates;
        }
        return null;
    }
}
