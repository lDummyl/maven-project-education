package customPackage.animals;

public class Ram extends Animal {
    private final boolean hasHorns;

    public Ram(String name, Gender gender, boolean hasHorns) {
        super(name, gender);
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
