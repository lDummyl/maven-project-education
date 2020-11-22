package task2;


public class Secretary extends Employee {

    @Override
    public int getSkills() {
        return skills.getLevelOfSkills();
    }
}
