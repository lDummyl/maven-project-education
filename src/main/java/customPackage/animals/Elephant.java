package customPackage.animals;

public class Elephant extends Animal {
    public Elephant(String name, Gender gender) {
        super(name, gender);
    }

    public static void main(String[] args) {
        Elephant hadoop = new Elephant("Hadoop", Gender.MALE);
        System.out.println(hadoop);
    }

    @Override
    public String scream() {
        return "Oomph!";
    }

    public boolean stepOn(Animal animal) {
        animal.isAlive = false;
        return animal.isAlive;
    }
}
