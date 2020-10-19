package CollectionWork;

import org.junit.Test;
import task1.Person;
import task1.PersonsProcessor;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class GeneratorTest {

    @Test
    public void treePersonGenerator() {
        Generator generator = new Generator();
        int expected = 40_000;
        TreeSet<Wanderer> wanderers = generator.treePersonGenerator(expected);
        assertEquals(expected, wanderers.size());

        Random random = new Random();
        Iterator<Wanderer> iterator = wanderers.iterator();
        Wanderer wanderer = null;
        for (int i = 0; i < random.nextInt(wanderers.size()); i++) {
            wanderer = iterator.next();
        }
        System.out.println(wanderer);
        int expecdeadHealth = 0;

       for (Wanderer w : wanderers) {
            assertTrue(w.health > expecdeadHealth);
            assertTrue(w.health <= Wanderer.MAXIMUM_HEALTH_POINT);

            assertTrue(w.weapon.type.getClass() == Varming.class || w.weapon.type.getClass() == Pistol.class);
        }

    }


    @Test
    public void arrayPersonGenerator() {
        Generator generator = new Generator();
        int expected = 40_000;
        ArrayList<Wanderer> wanderers = generator.arrayPersonGenerator(expected);
        assertEquals(expected, wanderers.size());
    }

    @Test
    public void uniArrayPersonGenerator() {
        Generator generator = new Generator();
        int expected = 40_000;
        ArrayList<Wanderer> wanderers = generator.uniArrayPersonGenerator(expected);
        assertEquals(expected, wanderers.size());

        boolean current = true;
        for (int i = 0; i < wanderers.size(); i++) {
            for (int j = i + 1; j < wanderers.size(); j++) {
                if (wanderers.get(j).equals(wanderers.get(i))) {
                    current = false;
                }
            }
            assertTrue(current);
        }

    }
}