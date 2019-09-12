package bonus;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class MyArrayListTest {

    Logger log = Logger.getLogger(MyArrayList.class.getName());

    MyArrayList<Integer> list = new MyArrayList<>();
    int size;

    @Test
    public void sizeTest () {
        int size = 10;
        fill(size);

        assertEquals(list.size(), size);
        assertFalse(list.isEmpty());
    }

    @Test
    public void containsTest () {
        int size = 10;
        fill(size);

        assertTrue(list.contains(4));
        list.remove(4);
        assertFalse(list.contains(4));
    }

    private void fill(int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }
}
