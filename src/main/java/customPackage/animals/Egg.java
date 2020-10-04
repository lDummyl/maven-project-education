package customPackage.animals;

public class Egg extends Child {

    public Egg(String name, Gender gender) {
        super(name, gender);
        name = "no_name";
        this.gender = gender;
    }

    public int growUp() {
        return 1;
    }
}