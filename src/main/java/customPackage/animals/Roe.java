package customPackage.animals;

public class Roe extends Child {

    public Roe(String name, Gender gender) {
        super(name, gender);
        name = "no-name";
        this.gender = Gender.NEUTRAL;
    }

    public int growUp() {
        return 1;
    }
}
