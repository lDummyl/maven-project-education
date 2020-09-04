package customPackage;

import customPackage.animals.Donkey;
import customPackage.animals.Snake;
import customPackage.people.Doctor;

public class cureDonkey {

    public static void main(String[] args) {
        Donkey maxie = new Donkey("Maxie");
        // maxie.health_status = false;
        Snake flossie = new Snake("Flossie", true);
        // Flossie bites Maxie
        flossie.bite(maxie);

        // Doctor cures poor Maxie
        Doctor johnson = new Doctor("Johnson");
//        String cured = johnson.curePatient("maxie", "ill");
        System.out.println("Health before:");
        System.out.println(maxie.health_status);
        johnson.curePatient(maxie);
        System.out.println("Health after:");
        System.out.println(maxie.health_status);
    }
}
