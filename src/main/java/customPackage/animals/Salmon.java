package customPackage.animals;

public class Salmon extends Animal {
    public boolean canBeEaten = true;

    public Salmon(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public String scream() {
        return "None";
    }
}
