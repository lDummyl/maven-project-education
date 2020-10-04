package customPackage.animals;

public class BabyParrot extends Child {

    public BabyParrot(String name, Gender gender) {
        super(name, gender);
        name = "no_name";
        this.gender = gender;
    }

    public int growUp() {
        return 1;
    }
}