package customPackage.animals;

public class Monkey extends Animal {
    private Banana banana;

    public Monkey(String name, boolean isAlive, Gender gender) {
        super(name, isAlive, gender);
    }

    public static void main(String[] args) {
        Banana banana = new Banana();
        Monkey abu = new Monkey("Abu", true, Gender.MALE);
        Monkey sam = new Monkey("Sam", true, Gender.FEMALE);
        abu.getBanana(banana);
        sam.stealBanana(abu);
        System.out.println(sam.banana);
        System.out.println(abu.banana);
    }

    @Override
    public String scream() {
        return "Cakara!";
    }

    public void getBanana(Banana banana) {
        this.banana = banana;
    }

    public void stealBanana(Monkey monkey) {
        if (monkey.banana != null) {
            this.banana = monkey.banana;
            monkey.banana = null;
        }
    }
}
