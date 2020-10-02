package customPackage.animals;

public abstract class Animal {
    public final String name;
    public boolean health_status;
    public boolean child;
    public Gender gender;
    public boolean isAlive = true;

    public abstract String scream();

    public Animal(String name, Gender gender) {
        this.name = name;
        this.health_status = true;
        this.child = false;
        this.gender = gender;
    }
}
