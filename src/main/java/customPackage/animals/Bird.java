package customPackage.animals;

public class Bird extends Animal {

    public Bird(String name, boolean isAlive, String gender) {
        super(name, isAlive, gender);
    }

    @Override
    public String scream() {
        return "chirp!";
    }
}
