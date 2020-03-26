package task2;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Boss hugoBoss = new Boss("Victor", 40, 1000, 30, 0, 10.5);
        System.out.println(hugoBoss.tellAccountantFactorForBonus(4));


        Random random = new Random();
        LabourMarket labourMarket = new LabourMarket(); // TODO: 3/21/20 рунок труда можно передать ХРу в конструктор например или отдельным методом
        Office office = new Office();
        Meteorologist meteorologist = new Meteorologist();

        List<Accountant> accountants = labourMarket.provideEmployee(4, Accountant.class); // TODO: 3/21/20 получаем 3 готовых бухгалтера
        List<Manager> managers = labourMarket.provideEmployee(1, Manager.class);// TODO: 3/21/20 получаем 1 менеджера

        List<HR> hrs = labourMarket.provideEmployee(1, HR.class);
        HR hr = hrs.get(0);
        hr.labourMarket = labourMarket;
        office.hr = hr;





     /*   HR hr = new HR(HR.tellBossKPIOfEmployees());
     //   Boss boss = new Boss(Boss.tellAccountantFactorForBonus(hr.KPI));
      //  Employee employee = new Employee("Victor", Employee.getRatePerHour(), Employee.tellAccountantQuantityOfWorkingDays(), Employee.tellAccountantQuantityOfOvertimeInHours());
     //   Accountant accountant = new Accountant();

     //   office.assign(boss);
      //  office.assign(hr);*/
     //   for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
        //    office.startWorkingDay(dayOfWeek); //ДЗ: enum на дни недели
        //}


        // TODO: 3/17/20 сделай такую очередность, сначала люди устраиваются на места, как птички рассаживаются по веткам после этого начинается рабочий день.
        //  Сделай так чтобы в новый день не нужно было назначать всех по новой но можно было бы запустить рабочий день опять и опять.
        //  Создай больше сотрудников нужен отбор при трудоустройстве всех кроме босса и HR. Единственный статический метод у тебя должен быть main.

      /*  System.out.print("Введите количество сотрудников: " );
        int employeeQuantity = input.nextInt();

        List<String> randomNames = Arrays.asList("Alla", "Zina", "Oleg", "Victor", "Olya", "Anna", "Semen", "Sasha");
        ArrayList<Employee> employeesList = new ArrayList<>();
        for (int i = 0; i < employeeQuantity; i++){
        //    Employee employee1 = new Employee(randomNames.get(random.nextInt(employeeQuantity)), Employee.getRatePerHour(), Employee.tellAccountantQuantityOfWorkingDays(), Employee.tellAccountantQuantityOfOvertimeInHours());
           // employeesList.add(employee1);
        }
        for (Employee employee1 : employeesList) {
            System.out.println(employee1);
        }*/
    }
}
