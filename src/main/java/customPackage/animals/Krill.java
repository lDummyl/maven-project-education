package customPackage.animals;

public class Krill extends Animal {
    public Krill(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Krill noname01 = new Krill("noname01");
        boolean metWhale = true;
        String isAlive;
        isAlive = noname01.isAlive(metWhale) ? "Yes" : "No";
        if (metWhale) {
            System.out.println("Is Krill alive? " + isAlive);
        }
    }

    @Override
    public String scream() {
        return "None...";
    }

    public boolean isAlive(boolean metWhale) {
        boolean status;
        status = !metWhale;
        return status;
    }
}
