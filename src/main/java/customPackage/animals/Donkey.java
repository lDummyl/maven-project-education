package customPackage.animals;

public class Donkey extends Animal {

    public Donkey(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public String scream() {
        return "Bray!";
    }

    public boolean steppedOnSnake() {
        return true;
    }
}