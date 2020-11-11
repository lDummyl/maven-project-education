package CollectionWork;

import java.util.Objects;
import java.util.Random;

public class Wanderer implements Comparable<Wanderer> {
    public static final int MAXIMUM_HEALTH_POINT = 1000;
    Weapon weapon;
    BirtDate birthDate;
    //int age;
    //static int i = 0;
    Integer health;
    Integer level;

    public Wanderer() {
        Random random = new Random();
        this.weapon = new Weapon();
        this.birthDate = new BirtDate();
        //this.age = age;
        this.health = 1 + random.nextInt(MAXIMUM_HEALTH_POINT);
        this.level = 1 + random.nextInt(1000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wanderer wanderer = (Wanderer) o;
        return health == wanderer.health &&
                level == wanderer.level &&
                Objects.equals(weapon, wanderer.weapon) &&
                Objects.equals(birthDate, wanderer.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weapon, birthDate, health, level);
    }

    @Override
    public int compareTo(Wanderer o) {
        return this.birthDate.compareTo(o.birthDate) * 3 + this.health.compareTo(o.health) + this.level.compareTo(o.level) + this.weapon.damage.compareTo(o.weapon.damage) + this.weapon.serialNumber.compareTo(o.weapon.serialNumber);
    }
}