package taskXI;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SingleRunnableTest {

    Logger log = Logger.getLogger(SingleRunnableTest.class.getName());
    List<Thread> threads = new ArrayList<>();
    volatile Integer valueInt = 0;
    AtomicInteger valueIntAtomic = new AtomicInteger(0);
    NonAtomicInteger nonAtomicInteger = new NonAtomicInteger(0);

    @SneakyThrows
    @Test
    public void easyTest () {
        fillAndStartThreads(20);

        for (Thread thread : threads) {
            thread.join();
        }


        assertEquals(threads.size() * 1000, (int) nonAtomicInteger.value);
        //assertEquals(threads.size(), valueIntAtomic.get());
    }

    private void fillAndStartThreads(int count) {
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(new SingleRunnable(nonAtomicInteger));
            thread.start();
            threads.add(thread);
        }
    }

//    public static void main(String[] args) {
//        Integer one = 129;
//        Integer two = one;
//        one++;
//        System.out.println(one == two);
//
//    }

}

