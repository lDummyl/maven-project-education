package customPackage.zoo.animals;

import customPackage.animals.Animal;

public class Turkey extends Animal {


    public Turkey(String name) {
        super(name);
    }

    @Override
    public String scream() {
        return "gobble!";
    }

    public int runAway(boolean threat) {
        int speed;
        if (threat) {
            speed = 10;
        } else {
            speed = 0;
        }
        return speed;
    }
}
