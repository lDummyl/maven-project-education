package customPackage.animals;

public class Lamb extends Child {

    @Override
    public Animal growUp() {

return new Sheep(name,gender);
    }

    public Lamb(String name, Gender gender) {
        super(name, gender);
    }

}
