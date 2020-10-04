package customPackage.animals;

public class BabyEagle extends Child {

    public BabyEagle(String name, Gender gender) {
        super(name, gender);
    }

    public int growUp() {
        return 3;
    }
}