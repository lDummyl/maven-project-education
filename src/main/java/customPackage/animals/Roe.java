package customPackage.animals;

public class Roe extends Child {

    @Override
    public Animal growUp() {
        return null;
    }

    public Roe(String name, Gender gender) {
        super(name, gender);
        name = "no-name";
        this.gender = Gender.NEUTRAL;
    }


}
