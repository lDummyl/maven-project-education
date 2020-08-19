package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Hr {
    private static final int NUMBER_OF_EMPLOYEES = 10;
    private static final int MIN_SKILLS = 5;
    private static final List<Secretary> secretaries = new ArrayList<>();
    private static final List<Security> securities = new ArrayList<>();
    private static final List<Lawyer> lawyers = new ArrayList<>();
    private static final List<Accountant> accountants = new ArrayList<>();
    private boolean secretariesIsFull = false;
    private boolean securitiesIsFull = false;
    private boolean lawyersIsFull = false;
    private boolean accountantsIsFull = false;

    public void invite(Object human) {
        if (human instanceof Employee && passInterview((Employee) human)) {
            sortEmployee(human);
        }
    }

    private boolean passInterview(Employee employee) {
        Random random = new Random();
        if (random.nextBoolean() && employee.getSkills() > MIN_SKILLS) {
            return true;
        }
        return false;
    }

    private void sortEmployee(Object human) {
        if (human instanceof Secretary) {
            if (checkNumberOfEmployees(secretaries)) {
                secretaries.add((Secretary) human);
            } else {
                secretariesIsFull = true;
            }
        } else if (human instanceof Security) {
            if (checkNumberOfEmployees(securities)) {
                securities.add((Security) human);
            } else {
                securitiesIsFull = true;
            }
        } else if (human instanceof Lawyer) {
            if (checkNumberOfEmployees(lawyers)) {
                lawyers.add((Lawyer) human);
            } else {
                lawyersIsFull = true;
            }
        } else if (human instanceof Accountant) {
            if (checkNumberOfEmployees(accountants)) {
                accountants.add((Accountant) human);
            } else {
                accountantsIsFull = true;
            }
        }
    }

    private boolean checkNumberOfEmployees(List<? extends Employee> employees) {
        return employees.size() < NUMBER_OF_EMPLOYEES;
    }

    public boolean employeesIsFull() {
        return securitiesIsFull && secretariesIsFull && lawyersIsFull && accountantsIsFull;
    }



}
