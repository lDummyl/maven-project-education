package task2;

import task1.BirthDate;
import task1.Name;

public class Lawyer extends Employee {

    public Lawyer(Name name, BirthDate birthDate, Skills skills) {
        super(name, birthDate, skills);
    }

    @Override
    public int getSkills() {
        return skills.getLevelOfSkills();
    }
}
