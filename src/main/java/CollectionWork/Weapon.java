package CollectionWork;

import java.util.Random;

public class Weapon {
    Object type;

    public Weapon() {
        Random random = new Random();
        int typeChose =1+random.nextInt(0);
        if (typeChose==1){
            this.type = new Pistol();
        }
    }
}
