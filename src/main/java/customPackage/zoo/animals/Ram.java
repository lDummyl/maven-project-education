package customPackage.zoo.animals;

import customPackage.animals.Animal;

public class Ram extends Animal {
    private final boolean hasHorns;

    public Ram(String name, boolean hasHorns) {
        super(name);
        this.hasHorns = hasHorns;

    }

    @Override
    public String scream() {
        return "Bla-a!";
    }

    public void mightyHit() {
        if (hasHorns) {
            System.out.println("Hit!");
        } else {
            System.out.println("Pain!");
        }
    }
}
