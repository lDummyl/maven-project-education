package task1;

public class Rabbit extends Animal {
    public Carrot eat (Carrot carrot) {
        System.out.println(name + " eats " + carrot);
        return carrot;
    }
}
