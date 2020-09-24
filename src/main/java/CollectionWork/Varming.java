package CollectionWork;

import java.util.Random;

public class Varming {
    int minDamage;
    int maxDamage;
    int status;
    int level;

    public Varming() {
        Random random = new Random();
        this.status = random.nextInt(100);
        this.level  = random.nextInt(100);
        this.minDamage = this.status * 20;
        this.maxDamage = this.level * 40;
    }
}
