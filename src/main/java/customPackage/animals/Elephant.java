package customPackage.animals;

public class Elephant extends Animal {
    public Elephant(String name, boolean isAlive) {
        super(name, isAlive);
    }

    public static void main(String[] args) {
        Elephant hadoop = new Elephant("Hadoop", true);
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
