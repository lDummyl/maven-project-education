package task2;

import task1.BirthDate;
import task1.Name;

public class Accountant extends Employee{

    public Accountant(Name name, BirthDate birthDate, Skills skills) {
        super(name, birthDate, skills);
    }

    @Override
    public int getSkills() {
        return skills.getLevelOfSkills();
    }
}
