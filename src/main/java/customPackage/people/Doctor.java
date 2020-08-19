package customPackage.people;

public class Doctor extends Person {

    public Doctor(String name) {
        super(name);
    }

    public boolean cure() {
        return true;
    }
}

