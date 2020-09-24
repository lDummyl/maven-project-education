package task1;

public class Pig extends Animal {
    public Pig(String name) {
        super(name);
    }

    public void live (Stable stable) {
        System.out.println(name + " lives in the " + stable);
    }
}
