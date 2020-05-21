package task2;

public abstract class OfficeWorker  {
    String fName, lName;
    int skill;

    public OfficeWorker(String fName, String lName, int skill) {
        this.fName = fName;
        this.lName = lName;
        this.skill = skill;
    }

    public OfficeWorker() {

    }

    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }

    public int getSkill() {
        return skill;
    }
}
