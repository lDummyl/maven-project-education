package customPackage.animals;

public class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    @Override
    public String scream() {
        return "chirp!";
    }
}
