package homeworkTask2;

import java.util.*;

public class Hr extends Person{
    public Hr(Name name, Age age) {
        super(name, age);
    }
    public Hr(Person person)
    {
        super(person.name, person.age);
    }

//    ArrayList <Person> candidates = new ArrayList<>();
    HashMap <Class <?>, List> map = new HashMap<>();
    ArrayList <Person> secretaries = new ArrayList<>();
    ArrayList <Person> accountants = new ArrayList<>();
    ArrayList <Person> jurists = new ArrayList<>();

    public HashMap invite (Object human)
    {
        if (human instanceof Secretary)
        {
            Secretary secretary = (Secretary) human;
            if (secretary.interview())
            {
                secretaries.add(secretary);
                map.put(Secretary.class, secretaries);
            }

            return map;
        }
        else if (human instanceof Accountant)
        {
            Accountant accountant = (Accountant) human;
            if (accountant.interview())
            {
                accountants.add(accountant);
                map.put(Accountant.class, accountants);
            }
            return map;

        }
        else if (human instanceof Jurist)
        {
            Jurist jurist = (Jurist) human;
            if (jurist.interview())
            {
                jurists.add(jurist);
                map.put(Jurist.class, jurists);
            }
            return map;
        }
        return null;
    }
}
