package taskXI;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class SingleRunnable implements Runnable {

    private Integer valueInt;
    private NonAtomicInteger nonAtomicInteger;
    private AtomicInteger valueIntAtomic;

    public SingleRunnable(Integer valueInt) {
        this.valueInt = valueInt;
    }

    public SingleRunnable(NonAtomicInteger nonAtomicInteger) {
        this.nonAtomicInteger = nonAtomicInteger;
    }

    public SingleRunnable(AtomicInteger valueIntAtomic) {
        this.valueIntAtomic = valueIntAtomic;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            nonAtomicInteger.increment();
        }
        //Calculations.calculate(valueInt);
        //valueIntAtomic.set(Calculations.calculateAtomicInt(valueIntAtomic));
    }
}
