package task2.Animals;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Tom");
        Dog dog = new Dog("Beam");

        cat.playBall(new Ball("blue ball"));
        dog.playBall(new Ball("red ball"));
    }
}
