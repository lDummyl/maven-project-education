package task2.AnimalsRepeat;

public class Dog extends Animal implements iPlayingBall{

    String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void playBall(Ball ball) {
        System.out.println("I'm playing ball " + ball + ", because I like it!");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
