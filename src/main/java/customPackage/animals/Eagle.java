package customPackage.animals;

public class Eagle extends Animal {
    public Eagle(String name, boolean isAlive) {
        super(name, isAlive);
    }

    public static void main(String[] args) {
        Eagle edgar = new Eagle("Edgar", true);
        System.out.println(edgar);
    }

    @Override
    public String scream() {
        return "Cle-e!";
    }
}
