package customPackage.animals;

public class Puppy extends Child {

    public Puppy(String name, Gender gender) {
        super(name, gender);
    }

    public int growUp() {
        return 1;
    }
}