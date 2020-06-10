package task2.AnimalsRepeat;

public class Cat extends Animal implements iPlayingBall{
    String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void playBall(Ball ball) {
        System.out.println("I'm noy playing ball " + ball + ", because I don't like it!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
