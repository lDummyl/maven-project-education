package customPackage.people;

public class Doctor extends Person {


    public Doctor(String name) {
        super(name);
    }

    public String curePatient(String name, String health) {
        if (name == "Dolly" || name == "Pirate") {
            health = null;
            System.out.println("Doctor treats humans only");
        } else {
            if (health == "ill") {
                health = "healthy";
            } else {
                System.out.println("No need to see a doctor!");
            }
        }
        return health;
    }
}