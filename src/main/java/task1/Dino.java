package task1;

public class Dino implements HasAge {

    BirthDate birthDate;

    public Dino() {
        birthDate = new BirthDate(-70_000_000);
    }

    @Override
    public BirthDate getBd() {
        return birthDate;
    }

    void scream() {
        System.out.println("Arrrrr!");
    }
}
