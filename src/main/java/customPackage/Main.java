package customPackage;

import customPackage.animals.Dog;
import customPackage.animals.Ram;
import customPackage.animals.Sheep;

public class Main {
    public static void main(String[] args) {
        Sheep dolly = new Sheep("Dolly", true, "female");
        Dog pirate = new Dog("Pirate", true, "male");
        System.out.println(dolly.scream());
        boolean threat = true;
        System.out.println(pirate.bite(threat));
        Ram mollie = new Ram("Mollie", false, "female", false);
        mollie.mightyHit();

    }
}
