package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Hr {


    // TODO: 8/20/20 как это связано с условием задачи?
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
        return random.nextBoolean() && employee.getSkills() > MIN_SKILLS;
    }

    // TODO: 8/20/20 поставь Sonar plugin и почини этот класс
    private void sortEmployee(Object human) {
        if (human instanceof Secretary) {
            secretariesIsFull = addEmployees(secretaries, (Secretary) human);
        } else if (human instanceof Security) {
            securitiesIsFull = addEmployees(securities, (Security) human);
        } else if (human instanceof Lawyer) {
            lawyersIsFull = addEmployees(lawyers, (Lawyer) human);
        } else if (human instanceof Accountant) {
            accountantsIsFull = addEmployees(accountants, (Accountant) human);
        }
    }

    private <T> boolean checkNumberOfEmployees(List<T> employees) {
        return employees.size() < NUMBER_OF_EMPLOYEES;
    }

    public boolean employeesIsFull() {
        return securitiesIsFull && secretariesIsFull && lawyersIsFull && accountantsIsFull;
    }

    private <T extends Employee> boolean addEmployees(List<T> employees, T employee) {
        if (checkNumberOfEmployees(employees)) {
            employees.add(employee);
            return false;
        }
        return true;
    }

}
