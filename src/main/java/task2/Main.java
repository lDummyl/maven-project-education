package task2;

public class Main {
    public static void main(String[] args) {
        Office office = new Office();
        HR hr = new HR(HR.tellBossKPIOfEmployees());
        Boss boss = new Boss(Boss.tellAccountantFactorForBonus(hr.KPI));
        Employee employee = new Employee("Victor", Employee.getRatePerHour(), Employee.tellAccountantQuantityOfWorkingDays(), Employee.tellAccountantQuantityOfOvertimeInHours());
        Accountant accountant = new Accountant();

        office.work(hr);    // отдает значения КПИ боссу
        office.work(boss);  // по значениям КПИ, boss составляет коэффициенты премий сотрудников за проект
        office.work(employee);  //сотрудник отдает бухгалтеру кол-во отработанных часов + кол-во переработок
        office.work(accountant, employee);  // на основе данных босса и сотрудника бух. считает зарплату, переработки и бонусы для сотрудника


        // TODO: 3/17/20 сделай такую очередность, сначала люди устраиваются на места, как птички рассаживаются по веткам после этого начинается рабочий день.
        //  Сделай так чтобы в новый день не нужно было назначать всех по новой но можно было бы запустить рабочий день опять и опять.
        //  Создай больше сотрудников нужен отбор при трудоустройстве всех кроме босса и HR. Единственный статический метод у тебя должен быть main.
    }
}
