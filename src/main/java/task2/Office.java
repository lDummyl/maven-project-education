package task2;

import lombok.NonNull;

public class Office {

    Boss boss;
    Accountant accountant;
    Employee employee;
    HR hr;

    void work(HR hr) {
        this.hr = hr;
        System.out.println("HR говорит KPI сотрудника боссу: " + hr.KPI);
    }

    void work(Boss boss) {
        this.boss = boss;
        System.out.println("Босс говорит бухгалтеру коэффициент сотрудника для дальнейшего подсчета премии: " + boss.tellAccountantFactorForBonus(hr.KPI));
    }

    void work(Employee employee) {
        this.employee = employee;
        System.out.println("Сотрудник сообщает ставку бухгалтеру: " + employee.rate);
        System.out.println("Сотрудник сообщает кол-во отработанных дней бухгалтеру: " + employee.workingHours);
        System.out.println("Сотрудник сообщает кол-во часов переработки бухгалтеру: " + employee.overtimeHours);

    }

    @NonNull
    void work(Accountant accountant, Employee employee) {
        this.accountant = accountant;
        this.employee = employee;
        System.out.println("Подсчет бухгалтером зарплаты сотрудника: " + accountant.countSalary(employee.workingHours, employee.rate));
        System.out.println("Подсчет бухгалтером надбавки за переработанные часы: " + accountant.countOvertimeBonus(employee.overtimeHours, employee.rate));
        System.out.println("Подсчет бухгалтером бонуса за проект: " + accountant.countProjectBonus(employee.rate, boss.factorForBonus));
    }

}
