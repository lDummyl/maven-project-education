package customPackage.animals;

public class Bull extends Animal {
    public Bull(String name, Gender gender) {
        super(name, gender);
        gender = Gender.MALE;
    }

    @Override
    public String scream() {
        return "Mooo!";
    }

}