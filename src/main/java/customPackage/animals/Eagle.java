package customPackage.animals;

public class Eagle extends Animal {
    public Eagle(String name, boolean isAlive, String gender) {
        super(name, isAlive, gender);
    }

    public static void main(String[] args) {
        Eagle edgar = new Eagle("Edgar", true, "male");
        System.out.println(edgar);
    }

    @Override
    public String scream() {
        return "Cle-e!";
    }

    public void eats(Animal animal) {
        if (animal instanceof Blackbird || animal instanceof Rookie) {
            System.out.println("Eagle ate " + animal.name + "!");
        }
    }

    public void nesting() {
        System.out.println("The eagle " + name + " is nesting!");
    }
}
