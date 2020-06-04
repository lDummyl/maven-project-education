package task2.Animals;

public class Main {
    public static void main(String[] args) {

        Owner owner = new Owner();
        owner.catsPlayBall(new Cat("Tom"));
        owner.dogsPlayBall(new Dog("Beam"));

        OwnersWife ownersWife = new OwnersWife();
        ownersWife.catsPlayBall(new Cat("Tom"));
        ownersWife.dogsPlayBall(new Dog("Beam"));

        People people = new People();
        people.catsPlayBall(new Cat("Tom"));
        people.dogsPlayBall(new Dog("Beam"));
    }
}
