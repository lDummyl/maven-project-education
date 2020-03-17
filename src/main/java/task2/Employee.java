package task2;

import java.util.Random;

public class Employee {

    static int tellAccountantQuantityOfWorkingDays() { // сказать количество рабочих дней за месяц
        Random random = new Random();
        int quantityOfWorkingDays = random.nextInt(22);

        return quantityOfWorkingDays;
    }

    static int tellAccountantQuantityOfOvertimeInHours() { // //сказать количество часов с переработкой
        Random random = new Random();
        int quantityOfOvertimeHours = random.nextInt(20);

        return quantityOfOvertimeHours;
    }

    static int getRatePerHour() {  //получить ставку в руб./час за сотрудника
        Random random = new Random();
        return random.nextInt(1500);
    }

    String name;
    int rate;
    int workingHours;
    int overtimeHours;
    Employee(String name, int rate, int workingHours, int overtimeHours){
        this.name = name;
        this.rate = rate;
        this.workingHours = workingHours;
        this.overtimeHours = overtimeHours;
    }
}
