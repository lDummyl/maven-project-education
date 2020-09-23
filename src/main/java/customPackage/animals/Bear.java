package customPackage.animals;

public class Bear extends Animal {
    public Bear(String name) {
        super(name);
    }

    @Override
    public String scream() {
        return "Roar";
    }
}
