package customPackage.animals;

public class Calf extends Animal {

    public Calf(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public String scream() {
        return "Mo-o!";
    }

    public void growUp() {
        child = false;
    }
}
