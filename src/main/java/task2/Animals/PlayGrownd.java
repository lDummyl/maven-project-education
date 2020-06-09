package task2.Animals;


import java.util.ArrayList;
import java.util.List;

public class PlayGrownd {

    List<Ball> balls = new ArrayList<>();
    Hospital hospital;

    public void invite(iPlayingBall iPlayingBall) {
        for (Ball ball : balls) {
            iPlayingBall.playBall(ball);
        }

    }
}
