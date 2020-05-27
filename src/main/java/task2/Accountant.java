package task2;

import task1.Person;

public class Accountant extends OfficeWorker{

    private Person person;

    public Accountant(Person person) {
        this.person = person;
    }

    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Accountant{" +
                person +
                '}';
    }
}
