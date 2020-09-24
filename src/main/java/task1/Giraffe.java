package task1;

public class Giraffe extends Animal {
    public Giraffe(String name) {
        super(name);
    }

    public Bananas eat (Bananas bananas) {
        System.out.println(name + " eats " + bananas);
        return bananas;
    }

}
