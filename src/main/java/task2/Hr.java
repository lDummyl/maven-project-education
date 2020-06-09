package task2;

import task1.BirthDate;
import task1.Person;
import task1.PersonProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Hr extends Person{

    public Hr(String name) {
        super(null, new BirthDate());
    }

    List<Secretary> candidates = new ArrayList<>();


    public Set<? extends Person> selectedPeople(int n) {
        Set<? extends Person> people = new PersonProvider().getPersons(n);
        return people;
    }


    public void invite(Object o) {

        if (o instanceof OfficeWorker) {
            OfficeWorker officeWorker = (OfficeWorker) o;
            if (officeWorker.passInterview()) {
                // TODO: 09.06.2020 add to list
            }else {
                System.out.println("Will call you back!");
            }
        }
    }
}




