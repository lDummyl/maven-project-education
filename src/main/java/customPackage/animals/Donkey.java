package customPackage.animals;

public class Donkey extends Animal {

    public Donkey(String name, boolean isAlive) {
        super(name, isAlive);
    }

    @Override
    public String scream() {
        return "Bray!";
    }

    public boolean steppedOnSnake() {
        return true;
    }
}