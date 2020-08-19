package task2;

import task1.BirthDate;
import task1.Name;
import task1.Person;

public abstract class Employee extends Person {

    Skills skills;

    public Employee(Name name, BirthDate birthDate, Skills skills) {
        super(name, birthDate);
        this.skills = skills;
    }

    public abstract int getSkills();
}
