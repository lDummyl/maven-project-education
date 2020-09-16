package customPackage.zoo.animals;

import customPackage.animals.Animal;

public class Snake extends customPackage.animals.Animal {
    private final boolean poisonous;


    public Snake(String name, boolean poisonous) {
        super(name);
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
