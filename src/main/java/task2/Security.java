package task2;

import task1.Person;

public class Security extends OfficeWorker{

    public OfficeWorker pal;

    private Person person;

    public Security(Person person) {
        this.person = person;
    }

//    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Security{" +
                person +
                '}';
    }

//    @Override
    void abs() {

    }
}
