package task2.Animals;

public class Dog implements iPlayingBall{
    String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void playBall(Ball ball) {
        System.out.println("I'm playing ball! " + ball);
    }



}
