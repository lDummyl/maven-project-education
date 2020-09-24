package task1;

public class Turtle extends Animal {
    public Turtle(String name) {
        super(name);
    }

    public Ninja use (Ninja ninja) {
        System.out.println(name + " uses the art of the " + ninja);
        return ninja;
    }
}
