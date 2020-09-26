package CollectionWork;

import java.util.Objects;
import java.util.Random;

public class Damage implements Comparable<Damage> {
    Integer minDamage;
    Integer maxDamage;
    Integer everegeDamage;

    public Damage() {
        Random random = new Random();
        this.minDamage = random.nextInt(10);
        this.maxDamage = random.nextInt(30);
        this.everegeDamage = (this.minDamage + this.maxDamage) / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Damage damage = (Damage) o;
        return Objects.equals(minDamage, damage.minDamage) &&
                Objects.equals(maxDamage, damage.maxDamage) &&
                Objects.equals(everegeDamage, damage.everegeDamage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minDamage, maxDamage, everegeDamage);
    }

    @Override
    public int compareTo(Damage o) {
        return this.everegeDamage.compareTo(o.everegeDamage);
    }
}
