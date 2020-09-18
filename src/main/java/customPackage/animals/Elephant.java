package customPackage.animals;

public class Elephant extends Animal {
    public Elephant(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Elephant hadoop = new Elephant("Hadoop");
        System.out.println(hadoop);
    }

    @Override
    public String scream() {
        return "Oomph!";
    }
}
