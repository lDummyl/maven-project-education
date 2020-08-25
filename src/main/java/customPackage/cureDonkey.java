package customPackage;

import customPackage.animals.Donkey;
import customPackage.animals.Snake;
import customPackage.people.Doctor;

public class cureDonkey {

    public static void main(String[] args) {
        Donkey maxie = new Donkey("Maxie");
        Snake flossie = new Snake("Flossie", true);
        // Maxie steps on Flossie
        Boolean event = maxie.steppedOnSnake();
        // Flossie bites Maxie
        Boolean stung = flossie.bite("Maxie");
        // Doctor cures poor Maxie
        Doctor johnson = new Doctor("Johnson");
        Boolean cured = johnson.cure();
    }
}
