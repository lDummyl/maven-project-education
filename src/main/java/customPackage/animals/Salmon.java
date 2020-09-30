package customPackage.animals;

public class Salmon extends Animal {
    public boolean canBeEaten = true;

    public Salmon(String name, boolean isAlive) {
        super(name, isAlive);
    }

    @Override
    public String scream() {
        return "None";
    }
}
