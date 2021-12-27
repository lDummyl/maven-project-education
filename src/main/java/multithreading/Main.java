package multithreading;

import java.util.ArrayList;

public class Main {
    static int i;

    synchronized void increment(){
        // так сделать можно, или это некорректно?
        // TODO: 12/27/2021 нет конечно. Ну это самая классическая ошибка,
        //  ты всю работу которая должна быть асинхронной делаешь в синхронном блоке. Так что у тебя получается валидный ответ но ты не получешь преимущества по скорости расчета никогда
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
        // TODO: 12/27/2021 а если будет 100 потоков будет 100 строк?

        // TODO: 12/27/2021 и потом куда пропали join?
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

