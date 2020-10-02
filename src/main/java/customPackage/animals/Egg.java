package customPackage.animals;

public class Egg extends Animal {

    public Egg(String name, Gender gender) {
        super(name, gender);
        name = "no_name";
        this.gender = gender;
    }

    @Override
    public String scream() {
        return "Doodle-doo!";
    }

    public void growUp() {
        child = false;
    }
}