package task2;

import task1.Person;

public class Jurist extends OfficeWorker{

    private Person person;

    public Jurist(Person person) {
        this.person = person;
    }

    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Jurist{" +
                person +
                '}';
    }
}
