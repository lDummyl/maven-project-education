package customPackage.people;

public class Shepperd extends Person {
    public Shepperd(String name) {
        super(name);
    }

    public String atWork() {
        String response = "Let's go";
        return response;
    }
}
