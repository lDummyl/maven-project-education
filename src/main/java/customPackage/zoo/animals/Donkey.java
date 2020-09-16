package customPackage.zoo.animals;

import customPackage.animals.Animal;

public class Donkey extends Animal {

    public Donkey(String name) {
        super(name);
    }

    @Override
    public String scream() {
        return "Bray!";
    }

    public boolean steppedOnSnake() {
        return true;
    }
}