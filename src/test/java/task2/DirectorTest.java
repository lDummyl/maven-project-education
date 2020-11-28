package task2;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DirectorTest {

    Director director = new Director(2);
    Map<Class<?>, List<Employee>> map = new HashMap<>();


    @Test
    public void listNull() {
        map.put(Secretary.class, null);
        Optional<Secretary> optionalSecretary = director.chooseEmployee(map, Secretary.class);
        try {
            Secretary secretary = optionalSecretary.get();
            fail();
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    public void listSizeLowerThanEnoughToDecide() {
        List<Employee> secretaryList = new ArrayList<>();
        secretaryList.add(new Secretary());
        map.put(Secretary.class, secretaryList);
        Optional<Secretary> optionalSecretary = director.chooseEmployee(map, Secretary.class);

        try {
            Secretary secretary = optionalSecretary.get();
            fail();
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    public void tempEmployeeDoesntInstanceEmployeeClass() {
        List<Employee> list = new ArrayList<>();
        list.add(new Secretary());
        list.add(new Secretary());
        map.put(Security.class, list);

        try {
            Optional<Security> optionalSecretary = director.chooseEmployee(map, Security.class);
            fail();
        } catch (IllegalStateException e) {
        }
    }
}