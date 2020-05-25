package task2;

import task1.Person;

public abstract class OfficeWorker  {

    private Person person;

    public OfficeWorker(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
