package task1;

public class Fish extends Animal{
    public Fish(String name) {
        super(name);
    }
    public void swim (Sea sea) {
        System.out.println(name + " swims into the " + sea);
    }
}
