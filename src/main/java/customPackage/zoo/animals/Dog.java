package customPackage.zoo.animals;

import customPackage.animals.Animal;
import customPackage.animals.Gender;

public class Dog extends Animal {


    public Dog(String name, boolean isAlive, Gender gender) {
        super(name, isAlive, gender);
    }

    @Override
    public String scream() {
        return "bark!";
    }

    public boolean bite(boolean threat) {
        boolean biten;
        biten = threat;
        return biten;
    }
}
