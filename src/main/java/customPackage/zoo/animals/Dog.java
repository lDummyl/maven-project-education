package customPackage.zoo.animals;

import customPackage.animals.Animal;

public class Dog extends Animal {


    public Dog(String name, boolean isAlive, String gender) {
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
