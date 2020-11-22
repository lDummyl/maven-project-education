package task2;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Director {

    private Random randomChoose;

    public Employee chooseEmployee(Map<Class<?>, List<Employee>> employees, Class<?> employeeClass) {
        List<Employee> tempList = employees.get(employeeClass);
        if (tempList != null && tempList.size() >= 10) {
            randomChoose = new Random();
            return tempList.get(randomChoose.nextInt(employees.size()));
        } else {
            return null;
        }
    }
}
