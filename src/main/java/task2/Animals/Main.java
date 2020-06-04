package task2.Animals;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Tom");
        Dog dog = new Dog("Beam");

//        cat.playBall(new Ball("blue ball"));
//        dog.playBall(new Ball("red ball"));

        Ball red_ball = new Ball("red ball");
        Ball blue_ball = new Ball("blue ball");

        PlayGrownd playGrownd = new PlayGrownd();
        playGrownd.balls.add(blue_ball);
        playGrownd.balls.add(red_ball);
        playGrownd.invite(dog);
        playGrownd.invite(cat);
    }
}
