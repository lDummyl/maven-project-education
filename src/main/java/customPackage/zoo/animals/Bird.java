package customPackage.zoo.animals;

import customPackage.animals.Animal;
import customPackage.animals.Gender;

public class Bird extends Animal {

    public Bird(String name, boolean isAlive, Gender gender) {
        super(name, isAlive, gender);
    }

    @Override
    public String scream() {
        return "chirp!";
    }
}
