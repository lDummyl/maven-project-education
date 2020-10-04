package customPackage.animals;

public class Calf extends Child {

    public Calf(String name, Gender gender) {
        super(name, gender);
    }

    public int growUp() {
        return 2;
    }
}
