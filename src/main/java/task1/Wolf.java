package task1;

public class Wolf extends Animal{
    public Wolf(String name) {
        super(name);
    }

    public Leader is (Leader leader) {


        System.out.println(name + " is the " + leader);
        return leader;
    }
}
