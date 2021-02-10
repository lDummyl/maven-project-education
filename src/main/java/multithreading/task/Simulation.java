package multithreading.task;

import multithreading.task.multi.MultiThreaded;
import multithreading.task.multi.Vault;
import multithreading.task.single.SingleThreaded;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Simulation {
    public void multiSimulation() throws InterruptedException {

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            threads.add(new MultiThreaded());
        }
        LocalDateTime before = LocalDateTime.now();

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        LocalDateTime after = LocalDateTime.now();
        System.out.println(Duration.between(before, after));
    }

    public void singleSimulation() throws InterruptedException {
        SingleThreaded singleThreaded = new SingleThreaded();
        LocalDateTime before = LocalDateTime.now();
        singleThreaded.simulation();
        LocalDateTime after = LocalDateTime.now();
        System.out.println(Duration.between(before, after));
    }

    public static void main(String[] args) throws InterruptedException {
        Simulation simulation = new Simulation();
        simulation.multiSimulation();
        System.out.println(Vault.count);
        simulation.singleSimulation();
    }
}
