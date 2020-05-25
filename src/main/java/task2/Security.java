package task2;

import task1.Person;

public class Security {

    private Person person;

    public Security(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Security{" +
                person +
                '}';
    }
}
