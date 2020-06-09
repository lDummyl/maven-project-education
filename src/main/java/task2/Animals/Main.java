package task2.Animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // TODO: 6/5/20 продолжим со зверушками. В площадке могут играть только привитые животные, остальные за забор.
    //  нужно создать ветклинику привть всех, создать побольше кошек и собак.
    //  И передавать их всех разом, при этом в этом методе только один вызов invite (сделать перегрузку этого метода).
    public static void main(String[] args) {

        Cat cat = new Cat("Tom");
        Cat cat2 = new Cat("Mom");
        Cat cat3 = new Cat("John");
        Dog dog = new Dog("Beam");
        Dog dog2 = new Dog("Jim");
        Dog dog3 = new Dog("Mob");

        List <Animals> patients = Arrays.asList(cat,cat2,cat3,dog,dog2,dog3);


//        cat.playBall(new Ball("blue ball"));
//        dog.playBall(new Ball("red ball"));

        Ball red_ball = new Ball("red ball");
        Ball blue_ball = new Ball("blue ball");

        PlayGrownd playGrownd = new PlayGrownd();
        playGrownd.balls.add(blue_ball);
        playGrownd.balls.add(red_ball);
//        playGrownd.invite(dog);
//        playGrownd.invite(cat);



        Hospital hospital = new Hospital(playGrownd);


    }
}
