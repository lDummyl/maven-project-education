package task2;

import task1.BirthDate;
import task1.Name;

public class Security extends Employee {

    @Override
    public int getSkills() {
        return skills.getLevelOfSkills();
    }
}
