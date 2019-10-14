package taskXI;

import java.util.concurrent.atomic.AtomicInteger;

public class Calculations {

    public static void calculate(Integer value) {
        value++;
    }

    public synchronized static void calculateSynchronized(Integer value) {
        calculate(value);
    }

    public static int calculateAtomicInt(AtomicInteger value) {
        return value.incrementAndGet();
    }
}
