package task2;

import java.util.List;
import java.util.Random;

public class Director {

    private Random randomChoose;

    Employee employee;

    public void chooseSecretary(List<? extends Employee> employees) {
        randomChoose = new Random();
        employee = employees.get(randomChoose.nextInt(employees.size() - 1));
    }

    public Employee getEmployee() {
        return employee;
    }

}
