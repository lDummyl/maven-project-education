package task2;

import java.util.Random;

public class HR extends Employee {

    double tellBossKPIOfEmployees() {
       Random random = new Random();

       return random.nextDouble() * 20;
    }

    double KPI;

    public HR(String name, int age, int rate, int workingHours, int overtimeHours, double KPI) {
        super(name, age, rate, workingHours, overtimeHours);
        this.KPI = KPI;
    }
    void fireEmployee() {
    }
}
