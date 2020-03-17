package task2;

public class Main {
    public static void main(String[] args) {
        Office office = new Office();
        Boss boss = new Boss();
        HR hr = new HR();
        Employee employee = new Employee();
        Accountant accountant = new Accountant();

        //  office.work(hr);    // отдает значения КПИ боссу
        office.work(boss);  // по значениям КПИ, boss составляет коэффициенты премий сотрудников за проект
        office.work(employee);  //сотрудник отдает бухгалтеру кол-во отработанных часов + кол-во переработок
        office.work(accountant);  // на основе данных босса и сотрудника бух. считает зарплату, переработки и бонусы для сотрудника
    }
}
