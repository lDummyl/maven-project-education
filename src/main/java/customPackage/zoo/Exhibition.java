package customPackage.zoo;

public abstract class Exhibition extends Zoo {
    public final String name;

    public Exhibition(String name) {
        super(name);
        this.name = name;
    }
}