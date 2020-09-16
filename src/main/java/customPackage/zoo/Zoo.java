package customPackage.zoo;

public abstract class Zoo {
    public final String name;

    public Zoo(String name) {
        this.name = name;
    }

    public abstract String scream();
}