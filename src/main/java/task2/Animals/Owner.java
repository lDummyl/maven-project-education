package task2.Animals;

public class Owner extends People implements iPlayingBall {


    @Override
    public void catsPlayBall(Cat cat) {
        System.out.println( "My cat " + cat + " is not playing ball!");
    }

    @Override
    public void dogsPlayBall(Dog dog) {
        System.out.println("My dog " + dog + " like playing ball!");
    }
}
