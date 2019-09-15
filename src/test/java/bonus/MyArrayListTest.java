package bonus;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class MyArrayListTest {

    Logger log = Logger.getLogger(MyArrayList.class.getName());

    MyArrayList<Integer> list = new MyArrayList<>();

    @Test
    public void sizeTest() {
        int size = 10;
        fill(size);

        assertEquals(size, list.size()); // исправил // TODO: 9/12/19 в этом асерте сначала идет оживаемый резульат а затем тот на кторый проверяем, на логику это не влияет, но мы получим репорт именно с такими размещением и если значания спутаны это затруднит понимание.
        assertFalse(list.isEmpty());
    }

    @Test
    public void fun1testValid() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 0, 0, 0, 5, 6, 7));
        List<Integer> zerosRange = integers.stream().skip(1).limit(3).collect(Collectors.toList());
        zerosRange.forEach(i -> assertEquals(0, (int) i));
        boolean changed = integers.removeAll(zerosRange);
        assertTrue(changed);
        assertFalse(integers.contains(0));
        assertTrue(integers.stream().noneMatch(i -> i == 0));
        assertTrue(integers.stream().allMatch(i -> i > 0));
        // TODO: 9/13/19 несколько примеров как можно, чем ровнее линия тем лучше, промежуточные состояния тоже приветствуются, стримы дают деклоративность в тестах это очень важно в них важна наглядность как нигде в коде
    }

    @Test
    public void addTest() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        list.addAll(integers);

        assertEquals(4, list.size());

        integers = Arrays.asList(0, 0, 0);
        list.addAll(2, integers);
        for (int i = 0; i < list.size(); i++) {
            if (i >= 2 && i <= 4) {
                assertEquals(0, (int) list.get(i));
            } else {
                assertNotEquals(0, (int) list.get(i));
            }
        }
        list.set(2, 22);
        assertEquals(22, (int) list.get(2));
    }

    @Test
    public void setGetTest() {
        fill(10);

        int number = list.get(5);
        assertEquals(5, number);

        list.set(0, 100);
        assertEquals(100, (int) list.get(0));
    }

    @Test
    public void removeTest() {
        int size = 10;
        fill(size);

        List<Integer> integers = Arrays.asList(1, 2);

        assertTrue(list.contains(4));
        list.remove(4);
        assertFalse(list.contains(4));

        list.removeAll(integers);
        assertFalse(list.containsAll(integers));

        integers = Arrays.asList(5, 6);
        list.retainAll(integers);
        assertTrue(list.containsAll(integers));

        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void indexOfTest() {
        List<Integer> integers = Arrays.asList(1, 1, 2, 3, 1, 4);

        list.addAll(integers);
        int index = list.indexOf(1);
        assertEquals(0, index);
        index = list.lastIndexOf(1);
        assertEquals(4, index);
    }

    @Test
    public void toArrayTest() {
        fill(10);

        Object[] array = list.toArray();
        assertEquals(list.size(), array.length);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), array[i]);
        }

        Integer[] integers = new Integer[list.size()];
        integers = list.toArray(integers);
        assertEquals(list.size(), integers.length);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), integers[i]);
        }
    }

    @Test
    public void iteratorsTest() {
        fill(100);

        Iterator<Integer> iterator = list.iterator();
        int iteratorSize = 0;
        while (iterator.hasNext()) {
            int value = iterator.next();
            int index = list.indexOf(value);
            assertEquals(index, iteratorSize);
            iteratorSize++;
        }

        ListIterator<Integer> listIterator = list.listIterator();
        iteratorSize = 0;
        while (listIterator.hasNext()) {
            int value = listIterator.next();
            int index = list.indexOf(value);
            assertEquals(index, iteratorSize);
            iteratorSize++;
        }

        listIterator = list.listIterator(90);
        iteratorSize = 0;
        while (listIterator.hasNext()) {
            listIterator.next();
            iteratorSize++;
        }
        assertEquals(10, iteratorSize);
    }

    @Test
    public void subListTest() {
        fill(30);

        List<Integer> subList = list.subList(10, 20);

        String ch1 = "";
        for (Integer i : list) {
            ch1 += i + " ";
        }
        log.info(ch1);
        ch1 = "";
        Integer integer = subList.get(0);
        System.out.println(integer);
        for (Integer i : subList) {
            ch1 += i + " ";
        }
        log.info(ch1);

        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            int index = subList.indexOf(value);
            if (i >= 10 && i <= 20) {
                assertEquals(i - 10, index);
            } else {
                assertEquals(-1, index);
            }
        }
    }

    private void fill(int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }
}
