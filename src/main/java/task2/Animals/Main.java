package task2.Animals;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Tom");
        Dog dog = new Dog("Beam");
        Ball blue_ball = new Ball("blue ball");
        Ball red_ball = new Ball("red ball");

        // TODO: 6/4/20 не трогая ничего в этом классе, создай Playdrownd так, чтобы все поиграли со всеми мячиками
        PlayGrownd playGrownd = new PlayGrownd();
        playGrownd.balls.add(blue_ball);
        playGrownd.balls.add(red_ball);
        playGrownd.invite(dog);
        playGrownd.invite(cat);
    }
}
