package customPackage.animals;

public class Salmon extends Animal {
    public boolean canBeEaten = true;

    public Salmon(String name, boolean isAlive, String gender) {
        super(name, isAlive, gender);
    }

    @Override
    public String scream() {
        return "None";
    }
}
