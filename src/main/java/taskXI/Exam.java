package taskXI;

/*

	После реализации всех задач, не более 1 недели на каждую(~2 мес) будет выдано
	тестовое задание на многопоточность из реального опыта трудоустройства,
	после его реализации 10 задач по SpringBoot,
	успех в которых позволит всерьез рассчитывать на трудоустройство на позицию Junior.

*/


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Exam {

    static volatile int a = 0;
    static AtomicInteger ai = new AtomicInteger(0);
    static ConcurrentHashMap<String, Number> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Execute());
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(a);
        System.out.println("ai = " + ai);
        map.values().forEach(System.out::println);
    }
    static class Execute implements Runnable{
        @Override
        public void run() {
            a++;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int andIncrement = ai.getAndIncrement();
            map.put(ai.toString(), andIncrement);
        }
    }
}
