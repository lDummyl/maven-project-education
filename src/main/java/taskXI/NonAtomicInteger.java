package taskXI;

public class NonAtomicInteger{

    int value;

    public NonAtomicInteger(int value) {
        this.value = value;
    }

    void increment(){
        value++;
    }

}
