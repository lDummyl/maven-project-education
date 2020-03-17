package task2;

public class Accountant {

    Employee employee;
    Boss boss;
    HR hr;

    int countSalary(int workingDays) {   //бухгалтер считает обычную зарплату сотрудника по обычной ставке (умножение отработанных дней на ставку за день)

        return workingDays * 8 * employee.getRatePerHour();
        //зарплата = кол-во раб дней * кол-во часов в день * ставка по часам
    }

    int countOvertimeBonus() {  //бухгалтер считает переработки сотрудника по двойной ставке

        return 2 * employee.tellAccountantQuantityOfOvertimeInHours() * employee.getRatePerHour();
        //переработка = 2 х кол-во часов х ставка сотрудника
    }

    double countProjectBonus() {  //бухгалтер считает бонус от закрытия проекта после подтверждения директора
        return employee.getRatePerHour() * boss.tellAccountantFactorForBonus(boss.getKpiFromHrToEstimateFactor(hr.tellBossKPIOfEmployees()));
        //бонус = ставка сотрудника * коэффициент от босса
    }

}
