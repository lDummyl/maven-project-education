package task2.Animals;

public class Main {
    // TODO: 6/5/20 продолжим со зверушками. В площадке могут играть только привитые животные, остальные за забор.
    //  нужно создать ветклинику привть всех, создать побольше кошек и собак.
    //  И передавать их всех разом, при этом в этом методе только один вызов invite (сделать перегрузку этого метода).
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
