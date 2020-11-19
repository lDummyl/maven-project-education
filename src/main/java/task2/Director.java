package task2;

import java.util.List;
import java.util.Random;

public class Director {

    private Random randomChoose;

    public Employee chooseEmployee(List<Employee> employees) {
        randomChoose = new Random();
        return employees.get(randomChoose.nextInt(employees.size() - 1));
    }

}
