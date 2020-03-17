package task2;

import java.util.Random;

public class Employee {
    Random random = new Random();


    int tellAccountantQuantityOfWorkingDays() { // сказать количество рабочих дней за месяц
        int quantityOfWorkingDays = random.nextInt(22);

        return quantityOfWorkingDays;
    }

    int tellAccountantQuantityOfOvertimeInHours() { // //сказать количество часов с переработкой
        int quantityOfOvertimeHours = random.nextInt(20);

        return quantityOfOvertimeHours;
    }

    int getRatePerHour() {  //получить ставку в тыс.руб./час за сотрудника
        return random.nextInt(10);
    }
}
