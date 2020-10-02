package customPackage.animals;

public class BabyParrot extends Animal {

    public BabyParrot(String name, Gender gender) {
        super(name, gender);
        name = "no_name";
        this.gender = gender;
    }

    @Override
    public String scream() {
        return "Crac-koo!";
    }

    public void growUp() {
        child = false;
    }
}