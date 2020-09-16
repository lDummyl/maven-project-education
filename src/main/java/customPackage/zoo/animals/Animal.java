package customPackage.zoo.animals;

public abstract class Animal {
    public final String name;
    public boolean health_status;

    public Animal(String name) {
        this.name = name;
        this.health_status = true;
    }

    public abstract String scream();
}
