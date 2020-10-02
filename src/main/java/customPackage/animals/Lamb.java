package customPackage.animals;

public class Lamb extends Animal {

    public Lamb(String name, Gender gender) {
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
