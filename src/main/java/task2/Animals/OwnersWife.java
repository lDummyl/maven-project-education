package task2.Animals;

public class OwnersWife extends People implements iPlayingBall {


    @Override
    public void catsPlayBall(Cat cat) {
        System.out.println("Play ball! " + cat);
    }

    @Override
    public void dogsPlayBall(Dog dog) {
        System.out.println("Play ball! " + dog);
    }


}
