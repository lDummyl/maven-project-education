package task3;

import java.time.LocalDate;
import java.util.Random;

public class Sleep {
    public static final int maximumSleepTimeSec = 60;
    int sleepTime;
    Random random = new Random();

    public Sleep(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public Sleep() {
        this.sleepTime = random.nextInt(maximumSleepTimeSec);
    }

    public static void sleep(){
        LocalDate now = LocalDate.now();
    }

}
