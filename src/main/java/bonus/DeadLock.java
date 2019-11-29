package bonus;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DeadLock {


    // Это вопрос из OCP exam. В нем объекты не имеют таких живих ассоциаций, для того чтобы помочь выработать интуитивное понимание,
    // я немного изменил их.
    // Чтобы это визуализировать представь 2 журнала, двух человек(Андрей и Яков) и две комнаты
    // в которых лежат журналы и может одновременно находится только один человек
    // Андрею чтобы добраться до второй комнаты нужно пройти через первую, заперев их обоих по очереди
    // Яков ходит к первому журналу через комнату где лежит второй и так же запирает за собой, так устроены их корридоры
    // опастность заключается в том что может оказаться так что Андрей по пути ко второму журналу оказался в комнате 1, запер ее
    // (комната заперта или открыта всегда со всех сторон)
    // и идет ко второй. Яков, в то же время, зашел во вторую комнату по направлению к первой, в которую он сможет попасть
    // только когда ее покинет Андрей, который сможет это сделать только когда вторая будет свободна от Якова.
    // Поскольку код не исполянется назад, каждый будет ждать пока что-то не здастся? чего не произойдет никогда. Это и есть DeadLock.

    // Для того чтобы считать это задание выполненным нужно преобразовтаь код так чтобы он достигал состояния DeadLock с почти 100% вроятностью при запуске.


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Object room1 = new Object();
        Object room2 = new Object();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<?> andrewAttempt = executorService.submit(() -> {
            synchronized (room1) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                synchronized (room2) {
                    System.out.println("Journal 2 visited");
                }
            }
        });

        Future<?> jacobAttempt = executorService.submit(() -> {
            synchronized (room2) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                synchronized (room1) {
                    System.out.println("Journal 1 visited");
                }
            }
        });

        andrewAttempt.get();
        jacobAttempt.get();
        executorService.shutdown();
    }

}

