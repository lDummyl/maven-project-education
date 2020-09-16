package customPackage.zoo;

public abstract class Department extends Zoo {
    public final String name;

    public Department(String name) {
        super(name);
        this.name = name;
    }
}
