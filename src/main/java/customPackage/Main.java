package customPackage;

import customPackage.animals.Dog;
import customPackage.animals.Sheep;

public class Main {
    public static void main(String[] args) {
        Sheep dolly = new Sheep("Dolly");
        Dog pirate = new Dog("Pirate");
        System.out.println(dolly.scream());
        boolean threat = true;
        System.out.println(pirate.bite(threat));
    }
}
