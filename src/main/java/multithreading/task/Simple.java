package multithreading.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Simple {
    static HashSet<Thread> threads = new HashSet<>();
    static volatile int counter;

    public static void stream() {

        IntStream.range(0, 10_000_000).parallel().forEach(i -> {
            increment();
            threads.add(Thread.currentThread());
            //System.out.println(Thread.currentThread().getName());
        });
    }

    public static void main(String[] args) {
        Simple.stream();
        System.out.println(counter);
        System.out.println(threads.size());
    }


    public static void main1(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());


        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Thread e = new Thread() {
                @Override
                public void run() {
                    synchronized (Simple.class) {
                        counter++;
                        counter++;
                        counter++;
                        counter++;
                        counter++;
                    }
                    ;

                }
            };
            e.start();
            threads.add(e);
        }
        System.out.println(threads.size());
        for (Thread thread : threads) {
            thread.join();
        }
        boolean isNoneAlive = threads.stream().noneMatch(Thread::isAlive);
        System.out.println(isNoneAlive);
        System.out.println(counter);
    }

    private static void increment() {
        counter++;
    }
}
