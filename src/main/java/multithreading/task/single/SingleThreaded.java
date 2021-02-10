package multithreading.task.single;

import lombok.SneakyThrows;

public class SingleThreaded {

    @SneakyThrows
    public void simulation(){
        for (int i = 0; i < 100; i++) {
            calculating();
        }
    }

    private void calculating() throws InterruptedException {
        int sleepTime = 10;
        Thread.sleep(sleepTime);
    }
}
