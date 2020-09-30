package customPackage.animals;

public class Bird extends Animal {

    public Bird(String name, boolean isAlive) {
        super(name, isAlive);
    }

    @Override
    public String scream() {
        return "chirp!";
    }
}
