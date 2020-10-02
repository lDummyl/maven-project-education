package customPackage;

import customPackage.animals.Dog;
import customPackage.animals.Gender;
import customPackage.animals.Ram;
import customPackage.animals.Sheep;

public class Main {
    public static void main(String[] args) {
        Sheep dolly = new Sheep("Dolly", Gender.FEMALE);
        Dog pirate = new Dog("Pirate", Gender.MALE);
        System.out.println(dolly.scream());
        boolean threat = true;
        System.out.println(pirate.bite(threat));
        Ram mollie = new Ram("Mollie", Gender.FEMALE, false);
        mollie.mightyHit();

    }
}
