package task2;

import task1.Person;

public class Accountant {

    private Person person;

    public Accountant(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Accountant{" +
                person +
                '}';
    }
}
