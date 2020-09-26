package CollectionWork;

import java.util.Objects;
import java.util.Random;

public class Pistol implements Comparable<Pistol> {
    public static final Integer power = 5;
    Integer status;
    Integer level;
    Damage damage;


    public Pistol() {
        Random random = new Random();
        this.status = random.nextInt(100) * this.power;
        this.level = random.nextInt(100) * this.power;
        this.damage = new Damage();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pistol pistol = (Pistol) o;
        return Objects.equals(status, pistol.status) &&
                Objects.equals(level, pistol.level) &&
                Objects.equals(damage, pistol.damage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, level, damage);
    }

    @Override
    public int compareTo(Pistol o) {
        return this.damage.compareTo(o.damage);
    }
}
