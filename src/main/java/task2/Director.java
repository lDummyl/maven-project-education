package task2;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Director {

    private Random randomChoose;

    public Employee chooseEmployee(Employee employee, Map<Class<?>, List<Employee>> employees, Class<?> employeeClass) {
        if (employee == null) { //если работник уже присвоен то выходим
            List<Employee> tempList = employees.get(employeeClass);
            if (tempList != null && tempList.size() >= 10) {
                randomChoose = new Random();
                Employee tempEmployee = tempList.get(randomChoose.nextInt(employees.size()));
                tempList.remove(tempEmployee); // удаляем работника который уже выбран
                employees.put(employeeClass, tempList);
                return tempEmployee;
            } else {
                return null;
            }
        }
        return employee;
    }
}
