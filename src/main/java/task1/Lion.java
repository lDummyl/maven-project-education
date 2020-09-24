package task1;

public class Lion extends Animal {
    public Lion(String name) {
        super(name);
    }
    public void overtake (Gazzele gazzele) {
        System.out.println(name + " overtakes " + gazzele);
    }
}
