package customPackage.animals;

public class BabyParrot extends Child {

    @Override
    public Animal growUp() {
        return null;
    }

    public BabyParrot(String name, Gender gender) {
        super(name, gender);
        name = "no_name";
        this.gender = gender;
    }


}