package CollectionWork;

import org.junit.Test;
import task1.Person;
import task1.PersonsProcessor;

import java.awt.font.NumericShaper;
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
        }

    }


}