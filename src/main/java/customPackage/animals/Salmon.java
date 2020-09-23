package customPackage.animals;

public class Salmon extends Animal {
    public Salmon(String name) {
        super(name);
    }

    @Override
    public String scream() {
        return "None";
    }
}
