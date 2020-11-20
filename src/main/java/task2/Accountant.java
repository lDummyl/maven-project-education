package task2;

import task1.BirthDate;
import task1.Name;

public class Accountant extends Employee {

    @Override
    public int getSkills() {
        return skills.getLevelOfSkills();
    }
}
