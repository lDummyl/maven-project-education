package customPackage.animals;

public abstract class Child {
    public final String name;
    public Gender gender;
    public boolean isAlive = true;

    public abstract int growUp();

    public Child(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
}