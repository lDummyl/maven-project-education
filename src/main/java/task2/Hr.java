package task2;

import task1.BirthDate;
import task1.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Hr {
    //пока незнаю как отсановить цикл подбора кандидатов
    private static final int NUMBER_OF_EMPLOYEES = 10;

    private static final int MIN_SKILLS = 5;
    private static final List<Employee> SECRETARIES = new ArrayList<>();
    private static final List<Employee> LAWYERS = new ArrayList<>();
    private static final List<Employee> SECURITIES = new ArrayList<>();
    private static final List<Employee> ACCOUNTANTS = new ArrayList<>();

    public void checkEmployee(Object human) {
        // TODO: 11/20/20 смотри как сделано в ветке iliaProject
        if (human instanceof Secretary) {
            passInterview((Secretary) human, SECRETARIES);
        } else if (human instanceof Lawyer) {
            passInterview((Lawyer) human, LAWYERS);
        } else if (human instanceof Security) {
            passInterview((Security) human, SECURITIES);
        } else if (human instanceof Accountant) {
            passInterview((Accountant) human, ACCOUNTANTS);
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

    // TODO: 11/20/20 директор не приходит к hr-у это hr отдает кандидатов на суд ему
    public Secretary chooseSecretary(Director director) {
        if (!checkNumberOfEmployees(SECRETARIES)) {
            return (Secretary) director.chooseEmployee(SECRETARIES);
        } else {
            return null;
        }
    }

    public Lawyer chooseLawyer(Director director) {
        if (!checkNumberOfEmployees(LAWYERS)) {
            return (Lawyer) director.chooseEmployee(LAWYERS);
        } else {
            return null;
        }
    }

    public Security chooseSecurity(Director director) {
        if (!checkNumberOfEmployees(SECURITIES)) {
            return (Security) director.chooseEmployee(SECURITIES);
        } else {
            return null;
        }
    }

    public Accountant chooseAccountant(Director director) {
        if (!checkNumberOfEmployees(ACCOUNTANTS)) {
            Accountant accountant = (Accountant) director.chooseEmployee(ACCOUNTANTS);
            ACCOUNTANTS.remove(accountant);
            ACCOUNTANTS.add(new Accountant(new Name(), new BirthDate(2020), new Skills()));  // похоже на костыль
            return accountant;
        } else {
            return null;
        }
    }

    public boolean doesntTired() {
        return checkNumberOfEmployees(SECRETARIES) || checkNumberOfEmployees(LAWYERS) || checkNumberOfEmployees(SECURITIES) || checkNumberOfEmployees(ACCOUNTANTS);
    }
}
