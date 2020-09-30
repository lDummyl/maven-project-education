package customPackage.zoo.animals;

import customPackage.animals.Animal;
import customPackage.animals.Gender;

public class Snake extends customPackage.animals.Animal {
    private final boolean poisonous;


    public Snake(String name, boolean isAlive, Gender gender, boolean poisonous) {
        super(name, isAlive, gender);
        this.poisonous = poisonous;
    }

    @Override
    public String scream() {
        return "Hiss!";
    }

    public void bite(Animal animal) {
        animal.health_status = false;
    }


}
