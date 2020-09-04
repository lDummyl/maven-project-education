package customPackage.animals;

public abstract class Animal {
    public final String name;
    public boolean health_status;

    public abstract String scream();

    public Animal(String name) {
        this.name = name;
        this.health_status = true;
    }
}
