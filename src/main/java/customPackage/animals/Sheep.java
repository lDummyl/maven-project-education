package customPackage.animals;

public class Sheep extends Animal {
    private final boolean ringBell;


    public Sheep(String name, boolean isAlive, Gender gender) {
        super(name, isAlive, gender);
        this.ringBell = true;
    }

    @Override
    public String scream() {
        return "Baa!";
    }

    public boolean eatGrass() {
        return true;
    }

//    public static void main(String[] args) {
//        Sheep dolly = new Sheep("Dolly");
//        System.out.println(dolly.scream());
//    }

}