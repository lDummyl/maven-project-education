package customPackage.zoo.animals;

import customPackage.animals.Animal;

public class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    @Override
    public String scream() {
        return "chirp!";
    }
}
