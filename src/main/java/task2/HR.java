package task2;

import java.util.List;
import java.util.Random;

public class HR extends Employee {

    public LabourMarket labourMarket;

    double tellBossKPIOfEmployees() {
       Random random = new Random();

       return random.nextDouble() * 20;
    }

    double KPI;

    public HR(String name, int age, int rate, int workingHours, int overtimeHours, double KPI) {
        super(name, age, rate, workingHours, overtimeHours);
        this.KPI = KPI;
    }


    public<T extends Employee> T hireEmployee(Class<T> emplClass) throws Exception {

        List<T> ts = labourMarket.provideEmployee(1, emplClass);
        return ts.get(0);
    }


}
