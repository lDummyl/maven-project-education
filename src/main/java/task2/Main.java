package task2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Boss hugoBoss = new Boss("Victor",40,1000,30,0,10.5);
        System.out.println( hugoBoss.tellAccountantFactorForBonus(4));


       Scanner input = new Scanner(System.in);
        Random random = new Random();

        Office office = new Office();
     /*   HR hr = new HR(HR.tellBossKPIOfEmployees());
     //   Boss boss = new Boss(Boss.tellAccountantFactorForBonus(hr.KPI));
      //  Employee employee = new Employee("Victor", Employee.getRatePerHour(), Employee.tellAccountantQuantityOfWorkingDays(), Employee.tellAccountantQuantityOfOvertimeInHours());
     //   Accountant accountant = new Accountant();

     //   office.assign(boss);
      //  office.assign(hr);*/
        office.startWorkingDay(); //ДЗ: enum на дни недели

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
