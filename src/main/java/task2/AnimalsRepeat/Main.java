package task2.AnimalsRepeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Tum");
        Dog dog = new Dog("Beam");
        Cat cat2 = new Cat("Dum");
        Dog dog2 = new Dog("Jimm");
        Cat cat3 = new Cat("Kum");
        Dog dog3 = new Dog("Rom");

        List <Animal> patients = Arrays.asList(cat,cat3,cat2,dog,dog2,dog3);

        Ball ball = new Ball("blue");
        Ball ball2 = new Ball("grey");
        PlayGround playGround = new PlayGround();
        playGround.balls.add(ball);
        playGround.balls.add(ball2);

        playGround.inviteToPlay(cat);
        playGround.inviteToPlay(dog);

        Hospital hospital = new Hospital();

        for (Animal animal:patients
             ) {hospital.invite(animal);
        }
        for (Animal animal : hospital.vaccinatedAnimals) {
            playGround.invite(animal);
        }



    }
}
