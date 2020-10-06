package customPackage.animals;

public class Puppy extends Child {


    @Override
    public Animal growUp() {
        return null;
    }

    public Puppy(String name, Gender gender) {
        super(name, gender);
    }


}