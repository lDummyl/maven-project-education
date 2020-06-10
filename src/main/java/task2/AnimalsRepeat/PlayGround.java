package task2.AnimalsRepeat;

import java.util.ArrayList;
import java.util.List;

public class PlayGround {

    List <Ball> balls = new ArrayList<>();


    public void inviteToPlay (iPlayingBall iPlayingBall){
        for (Ball ball : balls) {
            iPlayingBall.playBall(ball);
        }
    }

    public void invite (Animal animal){
        if(animal.isVaccinated){
            inviteToPlay(animal);
        }
    }

}
