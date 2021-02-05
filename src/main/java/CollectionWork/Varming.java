package CollectionWork;

import java.util.Random;

public class Varming implements Comparable<Varming>{
    Integer power = 10;
    Integer status;
    Integer level;
    Damage damage;

    public Varming() {
        Random random = new Random();
        this.status = random.nextInt(100) * this.power;
        this.level = random.nextInt(100) * this.power;
        this.damage = new Damage();
    }

    @Override
    public int compareTo(Varming o) {
        return this.damage.compareTo(o.damage);
    }
}
