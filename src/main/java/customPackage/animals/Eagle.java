package customPackage.animals;

public class Eagle extends Animal {
    public Eagle(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Eagle edgar = new Eagle("Edgar");
        System.out.println(edgar);
    }

    @Override
    public String scream() {
        return "Cle-e!";
    }
}
