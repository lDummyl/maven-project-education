package task2.NewOffice;


import task1.BirthDate;
import task1.Name;
import task1.Person;

import java.util.*;


public class Hr extends OfficeWorker {
    String name;
    Random random = new Random();


    public Hr(String name) {
        this.name = name;
    }

    public Set<Secretary> getSecretaries() {
        Set<Secretary> secretaries = new HashSet<>();
        int quantity = 1 + (random.nextInt(20));
        while (quantity > 0) {
            this.person = new Person(new Name(), new BirthDate());
            Secretary secretary = new Secretary(person);
            if (passAnInterview())
                secretaries.add(secretary);
            quantity--;
        }
        return secretaries;
    }

    public Set<ApplyingForAJob> makeCasting(Set<? extends OfficeWorker> set) {
        Set<ApplyingForAJob> hrChoice = new HashSet<>();
        for (OfficeWorker officeWorker : set) {
            if (officeWorker.passAnInterview()) {
                hrChoice.add(officeWorker);
            }
        }
        return hrChoice;
    }

}
