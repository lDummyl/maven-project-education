package Jet;

import java.time.LocalDate;
import java.util.TreeSet;

public class Comp implements Comparable<Comp> {
    LocalDate bd;
    Integer health;
    Integer dam;

    public static void main(String[] args) {
        TreeSet<Comp> objects = new TreeSet<>();
        Comp comp = new Comp();
        comp.bd = LocalDate.now();
        comp.health = 100;
        comp.dam = 1000;

        Comp comp1 = new Comp();
        comp1.bd = LocalDate.now().minusDays(1);
        comp1.health = 1000;
        comp1.dam = 10000;


        objects.add(comp);
        objects.add(comp1);
        System.out.println(objects.first());
    }

    @Override
    public String toString() {
        return "Comp{" +
                "bd=" + bd +
                ", health=" + health +
                '}';
    }

    @Override
    public int compareTo(Comp o) {

        return this.bd.compareTo(o.bd) + this.health.compareTo(o.health) + this.dam.compareTo(o.dam);
    }
}
