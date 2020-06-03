package task2;

import task1.BirthDate;
import task1.Person;
import task1.PersonProvider;

import java.util.Set;

public class Hr extends Person{

    public Hr(String name) {
        super(null, new BirthDate());
    }

    public Set<? extends Person> selectedPeople(int n) {
        Set<? extends Person> people = new PersonProvider().getPersons(n);
        return people;
    }


}




