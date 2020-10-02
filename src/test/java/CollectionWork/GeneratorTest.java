package CollectionWork;

import org.junit.Test;
import task1.PersonsProcessor;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class GeneratorTest {

    @Test
    public void treePersonGenerator() {
        Generator generator = new Generator();
        int expected = 40_000;
        TreeSet<Wanderer> wanderers = generator.treePersonGenerator(expected);
        assertEquals(expected, wanderers.size());
    }
}