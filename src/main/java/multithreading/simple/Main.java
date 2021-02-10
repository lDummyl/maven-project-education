package multithreading.simple;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        counter.start();
        int millis = 5000;

        while (true) {
            System.out.println(millis);
            Thread.sleep(millis);
            counter.multiplier++;
            millis -= 200;
        }
    }
}
