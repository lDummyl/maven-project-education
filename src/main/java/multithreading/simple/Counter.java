package multithreading.simple;

public class Counter extends Thread {
    public volatile int multiplier = 2;
    public int startValue = 1;
    public long value = startValue;

    @Override
    public void run() {
        do {
            if (!Thread.interrupted()) {
                value *= multiplier;
                System.out.println(multiplier);
                System.out.println(value);
                System.out.println();
            } else {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
        while (true);
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
