package task1;

public class Elepfant extends Animal {
    public Elepfant(String name) {
        super(name);
    }

    public Water drink (Water water) {
        System.out.println(name + " drinks the" + water);
        return water;
    }
}