package task2;

import task1.BirthDate;
import task1.Person;
import task1.PersonProvider;

import java.util.Random;
import java.util.Set;

public class Hr extends Person{

    Random random = new Random();

    public Hr(String name) {
        super(null, new BirthDate());
    }

    Set<Secretary> secretaries = (Set<Secretary>) selectedPeople();


    public Set<? extends Person> selectedPeople() {
        Set<? extends Person> people = new PersonProvider().getPersons(1+random.nextInt(10));
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




