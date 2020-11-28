package task2;

import java.util.*;


public class Hr {

    private static final int MIN_SKILLS = 5;

    private static final Map<Class<?>, List<Employee>> EMPLOYEES = new HashMap<>();

    public void checkEmployee(Object human) {
        Class<?> classEmployee = human.getClass();
        List<Employee> employeeList = EMPLOYEES.get(classEmployee);
        if (((Employee)human).skills.getLevelOfSkills() > MIN_SKILLS) {
            if (employeeList != null) {
                employeeList.add((Employee) human);
            } else {
                employeeList = new ArrayList<>();
                employeeList.add((Employee) human);
                EMPLOYEES.put(classEmployee, employeeList);
            }
        }
    }

    public Map<Class<?>, List<Employee>> getListEmployee() {
        return EMPLOYEES;
    }
}
