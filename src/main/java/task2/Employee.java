package task2;

import task1.Person;

public abstract class Employee extends Person {

    Skills skills;

    public Employee(Skills skills) {
        super();
        this.skills = skills;
    }

    public abstract int getSkills();
}
