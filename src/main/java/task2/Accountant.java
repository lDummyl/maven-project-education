package task2;

public class Accountant {


    int countSalary(int workingDays, int rate) {   //бухгалтер считает обычную зарплату сотрудника по обычной ставке (умножение отработанных дней на ставку за день)

        return workingDays * 8 * rate;
        //зарплата = кол-во раб дней * кол-во часов в день * ставка по часам
    }

    int countOvertimeBonus(int overtimeHours, int rate) {  //бухгалтер считает переработки сотрудника по двойной ставке

        return 2 * overtimeHours * rate;
        //переработка = 2 х кол-во часов х ставка сотрудника
    }

    double countProjectBonus(int rate, double factorForBonus) {  //бухгалтер считает бонус от закрытия проекта после подтверждения директора
        return rate * factorForBonus;
        //бонус = ставка сотрудника * коэффициент от босса
    }

}
