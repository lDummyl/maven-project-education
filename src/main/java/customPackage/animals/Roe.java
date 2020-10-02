package customPackage.animals;

public class Roe extends Animal {

    public Roe(String name, Gender gender) {
        super(name, gender);
        name = "no-name";
        this.gender = Gender.NEUTRAL;
    }

    @Override
    public String scream() {
        return "Silence...";
    }

    public void growUp() {
        child = false;
    }
}
