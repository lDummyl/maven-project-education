package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Hr {
    private static final int NUMBER_OF_EMPLOYEES = 10;
    private static final int MIN_SKILLS = 5;
    private static final List<Employee> SECRETARIES = new ArrayList<>();

    public void checkEmployee(Object human) {
        if (human instanceof Secretary) {
            passInterview((Secretary) human, SECRETARIES);
        }
    }

    private boolean checkNumberOfEmployees(List<Employee> employees) {
        return employees.size() < NUMBER_OF_EMPLOYEES;
    }

    private void passInterview(Employee employee, List<Employee> employees) {
        Random random = new Random();
        if (random.nextBoolean() && employee.getSkills() > MIN_SKILLS) {
            employees.add(employee);
        }
    }

    public Secretary chooseSecretary(Director director) {
        if (!checkNumberOfEmployees(SECRETARIES)) {
            return (Secretary) director.chooseEmployee(SECRETARIES);
        } else {
            return null;
        }
    }

    public boolean doesntTired() {
        return checkNumberOfEmployees(SECRETARIES);
    }
}
