package cats;

import static cats.Character.ANGRY;
import static cats.Character.KIND;

public class Cat {

    Character character;

    public Cat(Character character) {
        this.character = character;
    }

    public void action(){
        if (character == KIND){
            System.out.println("fur-fur-fur-fur");
        } else if (character == ANGRY) {
            System.out.println("Hit the face!");
        }
    }

}
