package task2;

import task1.Person;

public abstract class Employee extends Person {

    Skills skills;

    public Employee() {
        super();
        skills = new Skills();
    }

    public abstract int getSkills();
}
