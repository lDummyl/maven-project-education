package customPackage.people;

public class Secretary extends Person {
    private final int age;

    public Secretary(String name, int age) {
        super(name);
        this.age = age;
    }

    public static void main(String[] args) {
        Secretary maryHopkins = new Secretary("Hopkins", 45);
        Manager johnSimpson = new Manager("John Simpson", 50);
        boolean hired = false;
        boolean getHired = false;
        getHired = johnSimpson.hireSecretary(maryHopkins.name, hired);
    }
}
