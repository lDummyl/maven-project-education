package task3;

public class TakeABreak extends Thread {
    private int timeToRelax;

    public int getTimeToRelax() {
        return timeToRelax;
    }

    public void setTimeToRelax(int timeToRelax) {
        this.timeToRelax = timeToRelax;
    }

    @Override
    public void run() {
        while (timeToRelax > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
            }
            timeToRelax--;
        }


    }
}
