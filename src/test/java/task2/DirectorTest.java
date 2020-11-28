package task2;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DirectorTest {

    Director director = new Director(2);
    Map<Class<?>, List<Employee>> map = new HashMap<>();


    @Test(expected = NoSuchElementException.class)
    public void listNull() {
        map.put(Secretary.class, null);
        Optional<Secretary> optionalSecretary = director.chooseEmployee(map, Secretary.class);
        Secretary secretary = optionalSecretary.get();
    }


    @Test(expected = NoSuchElementException.class)
    public void listSizeLowerThanEnoughToDecide() {
        List<Employee> secretaryList = new ArrayList<>();
        secretaryList.add(new Secretary());
        map.put(Secretary.class, secretaryList);
        Optional<Secretary> optionalSecretary = director.chooseEmployee(map, Secretary.class);
        Secretary secretary = optionalSecretary.get();
    }

    @Test(expected = IllegalStateException.class)
    public void tempEmployeeDoesntInstanceEmployeeClass() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Secretary());
        employeeList.add(new Secretary());
        map.put(Security.class, employeeList);
        Optional<Security> optionalSecretary = director.chooseEmployee(map, Security.class);
    }

}