package task2;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Director {

    private Random randomChoose;

    public Secretary chooseEmployee(Map<Class<?>, List<Employee>> employees) {
        List<Employee> tempList = employees.get(Secretary.class);
        if (tempList != null && tempList.size() >= 10) {
            randomChoose = new Random();
            return (Secretary) tempList.get(randomChoose.nextInt(employees.size()));
        } else {
            return null;
        }
    }

}
