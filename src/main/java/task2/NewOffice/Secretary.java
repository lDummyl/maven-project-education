package task2.NewOffice;

import task1.Person;


public class Secretary extends OfficeWorker implements ApplyingForAJob {

    Person person;
    OfficeWorker officeWorker;


    public Secretary(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "person=" + person +
                '}';
    }
}
