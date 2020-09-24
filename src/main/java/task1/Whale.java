package task1;

public class Whale extends Animal {
    public Whale(String name) {
        super(name);
    }

    public Ocean live (Ocean ocean) {


        System.out.println(name + " lives on the " + ocean);
        return ocean;
    }
}
