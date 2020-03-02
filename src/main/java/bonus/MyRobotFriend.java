package bonus;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class MyRobotFriend {
    public static void main(String[] args) throws AWTException, InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
    }
}
