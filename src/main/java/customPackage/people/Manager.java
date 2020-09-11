package customPackage.people;

public class Manager extends Person {
    private final int age;

    public Manager(String name, int age) {
        super(name);
        this.age = age;
    }

    public boolean hireSecretary(String name, boolean hired) {
        if (hired = false && name != null) {
            hired = true;
        }
        return hired;
    }

    public boolean terminateSecretary(String name, boolean hired) {
        if (hired = true && name != null) {
            hired = false;
        }
        return hired;
    }


}
