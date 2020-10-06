package customPackage.animals;

public class Egg extends Child {

    @Override
    public Animal growUp() {
        return null;
    }

    public Egg(String name, Gender gender) {
        super(name, gender);
        name = "no_name";
        this.gender = gender;
    }


}