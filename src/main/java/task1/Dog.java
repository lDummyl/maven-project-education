package task1;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public Stick run (Stick stick) {
        System.out.println(name + " runs for the " + stick);
        return stick;
    }


}
