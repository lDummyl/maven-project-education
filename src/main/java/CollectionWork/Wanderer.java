package CollectionWork;

import java.util.Objects;
import java.util.Random;

public class Wanderer implements Comparable<Wanderer> {
    Weapon weapon;
    BirtDate birthDate;
    //int age;
    //static int i = 0;
    int health;
    int level;

    public Wanderer() {
        Random random = new Random();
        this.weapon = new Weapon();
        this.birthDate = new BirtDate();
        //this.age = age;
        this.health = 1 + random.nextInt(99);
        this.level = 1 + random.nextInt(99);
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
        return this.birthDate.compareTo(o.birthDate);
    }
}
