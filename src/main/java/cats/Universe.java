package cats;

import static cats.Character.ANGRY;
import static cats.Character.KIND;

public class Universe {

    public static void main(String[] args) {
        Cat angryCat = new Cat(ANGRY);
        Cat kindKat = new Cat(KIND);
        kindKat.action();

    }
}
