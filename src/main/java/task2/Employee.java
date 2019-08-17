package task2;

public abstract class Employee implements WantAJob {

    private final String name;
    private Office officeImHiredIn;

    protected Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Office getOfficeImHiredIn() {
        return officeImHiredIn;
    }

    public void setOfficeImHiredIn(Office officeImHiredIn) {
        this.officeImHiredIn = officeImHiredIn;
    }
}
