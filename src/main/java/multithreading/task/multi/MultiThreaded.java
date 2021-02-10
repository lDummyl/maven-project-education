package multithreading.task.multi;

import lombok.SneakyThrows;

public class MultiThreaded extends Thread{
    public static volatile int counter;
    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(10);
        Vault.increment();
    }
}
