package customPackage.people;

public class Shepperd extends Person {
    public Shepperd(String name, int age) {
        super(name, age);
    }

    public String atWork() {
        String response = "Let's go";
        return response;
    }
}
