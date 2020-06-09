package task2.Animals;


import java.util.ArrayList;
import java.util.List;

public class PlayGrownd {

    List<Ball> balls = new ArrayList<>();
    // TODO: 6/9/20 ясно, теперь на площадке появился встроенный госпиталь, отдельно им не выжить
    Hospital hospital;

    public void invite(iPlayingBall iPlayingBall) {
        for (Ball ball : balls) {
            iPlayingBall.playBall(ball);
        }

    }
}
