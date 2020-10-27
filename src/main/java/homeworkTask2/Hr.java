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
    public void init (Office office, Object worker)
    {
        if (worker.getClass().equals(Secretary.class)) {
            office.secretary = (Secretary) worker;
        }
        if (worker.getClass().equals(Accountant.class))
        {
            office.accountant = (Accountant) worker;
        }
        if (worker.getClass().equals(Jurist.class))
        {
            office.jurist = (Jurist) worker;
        }
    }
}
