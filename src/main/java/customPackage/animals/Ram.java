package customPackage.animals;

public class Ram extends Animal {
    private final boolean hasHorns;

    public Ram(String name, boolean isAlive, String gender, boolean hasHorns) {
        super(name, isAlive, gender);
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
