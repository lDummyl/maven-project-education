package task2;

public class Office {

    Boss boss;
    Accountant accountant;
    Employee employee;
    HR hr;

    double work(HR hr) {
        this.hr = hr;
        return hr.tellBossKPIOfEmployees();
    }

    void work(Boss boss) {
        this.boss = boss;
        boss.tellAccountantFactorForBonus(work(hr));
    }

    void work(Employee employee) {
        this.employee = employee;
        employee.tellAccountantQuantityOfWorkingDays();
        employee.tellAccountantQuantityOfOvertimeInHours();

    }

    void work(Accountant accountant) {
        this.accountant = accountant;
        accountant.countSalary(employee.tellAccountantQuantityOfWorkingDays());
        accountant.countOvertimeBonus();
        accountant.countProjectBonus();
    }
}
