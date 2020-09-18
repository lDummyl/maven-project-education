package customPackage.animals;

public class Krill extends Animal {
    private boolean isAlive = true;

    public Krill(String name) {
        super(name);
    }

    @Override
    public String scream() {
        return "None...";
    }

    @Override
    public String toString() {
        return "Krill{" +
                "isAlive=" + isAlive +
                ", name='" + name + '\'' +
                '}';
    }

    public void die() {
        isAlive = false;
        System.out.println("Krill was eaten!");
    }
}
