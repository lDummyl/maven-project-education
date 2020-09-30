package customPackage.animals;

public class Eagle extends Animal {
    public Eagle(String name, boolean isAlive, Gender gender) {
        super(name, isAlive, gender);
    }

    public static void main(String[] args) {
        Eagle edgar = new Eagle("Edgar", true, Gender.MALE);
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

    public Egg createEgg(Eagle other_parent) {
        Egg egg = null;
        if (other_parent.gender == this.gender) {
            System.out.println("No egg is created!");
        } else {
            egg = new Egg();
        }
        return egg;
    }

    public void nesting() {
        System.out.println("The eagle " + name + " is nesting!");
    }
}
