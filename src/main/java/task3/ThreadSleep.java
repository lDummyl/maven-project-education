package task3;

import java.util.Random;

public class ThreadSleep extends Thread {

    private int sleepTime = 0;
    Random random = new Random();

    public ThreadSleep(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            sleepTime = random.nextInt(50) + 10;
            this.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
            sleepTime = 0;
            //e.printStackTrace();
        }
    }

    // тут ступор. не знаю как узнать оставшееся время сна потока
    public int getSleepTime() {
        return sleepTime;
    }
}
