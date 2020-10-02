package customPackage.animals;

public class Puppy extends Animal {

    public Puppy(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public String scream() {
        return "Bark!";
    }

    public void growUp() {
        child = false;
    }
}