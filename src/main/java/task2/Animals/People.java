package task2.Animals;

public class People implements iPlayingBall{
    @Override
    public void catsPlayBall(Cat cat) {
        System.out.println("only implements");
    }

    @Override
    public void dogsPlayBall(Dog dog) {
        System.out.println("only implements");
    }
}
