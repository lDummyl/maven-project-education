package CollectionWork;

import java.util.Random;

public class Weapon implements Comparable<Weapon> {
    Object type;
    Damage damage;
    Integer serialNumber;

    public Weapon() {
        Random random = new Random();
        this.serialNumber = random.nextInt(2_147_483_647);
        int typeChose = 1 + random.nextInt(1);
        if (typeChose == 1) {
            Pistol p = new Pistol();
            this.type = p;
            this.damage = p.damage;
        } else if (typeChose == 2) {

            Varming v = new Varming();
            this.type = v;
            this.damage = v.damage;
        }
    }

    @Override
    public int compareTo(Weapon o) {
        return this.damage.compareTo(o.damage);
    }
}
