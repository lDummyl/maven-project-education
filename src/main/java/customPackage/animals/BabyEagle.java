package customPackage.animals;

public class BabyEagle extends Animal {

    public BabyEagle(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public String scream() {
        return "Doodle-doo!";
    }

    public void growUp() {
        child = false;
    }
}