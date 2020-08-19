package task2;

import task1.BirthDate;
import task1.Name;

public class Security extends Employee {

    public Security(Name name, BirthDate birthDate, Skills skills) {
        super(name, birthDate, skills);
    }

    @Override
    public int getSkills() {
        return skills.getLevelOfSkills();
    }
}
