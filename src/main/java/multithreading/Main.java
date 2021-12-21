package multithreading;

import java.util.ArrayList;

public class Main {
    static int i;
    synchronized void increment(){
        // так сделать можно, или это некорректно?
        i = -2;
        for (int j = 0; j < 1000; j++) {
            i++;
        }
        System.out.println(Thread.currentThread().getName());
    }


    public static void main(String[] args) throws InterruptedException {
        Job job = new Job();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int j = 1; j < 9; j++) {
            String name = "thread" + j;
            Thread thread = new Thread(job);
            thread.setName(name);
            threads.add(thread);
        }
        threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();
        threads.get(3).start();
        threads.get(4).start();
        threads.get(5).start();
        threads.get(6).start();
        threads.get(7).start();
        System.out.println(i);
        System.out.println(Thread.currentThread().getName());
    }

    static class Job implements Runnable {
        Main main = new Main();

        @Override
        public void run() {
            main.increment();
        }
    }
}

