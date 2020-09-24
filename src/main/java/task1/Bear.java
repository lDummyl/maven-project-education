package task1;

public class Bear extends Animal{
    public Bear(String name) {
        super(name);
    }

    public Honey climb (Honey honey) {


        System.out.println(name + " climbs" + honey);
        return honey;
    }
}
