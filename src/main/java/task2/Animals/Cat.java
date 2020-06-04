package task2.Animals;

public class Cat implements iPlayingBall{

    String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void playBall(Ball ball) {
        System.out.println("I'm not playing ball");
    }
}
