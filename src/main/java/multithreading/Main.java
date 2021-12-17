package multithreading;

import java.time.LocalDateTime;

public class Main {
    static int i;

    public static void main(String[] args) throws InterruptedException {
        Job job = new Job();
        Job job2 = new Job();
        Thread thread = new Thread(job);
        Thread thread2 = new Thread(job2);
        System.out.println(LocalDateTime.now());
        thread.start();
        thread2.start();
        thread.join();
        System.out.println(i);
        System.out.println(Thread.currentThread().getName());
        System.out.println(LocalDateTime.now());

    }
    static class Job implements Runnable {

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
                for (int j = 0; j < 10000000; j++) {
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

