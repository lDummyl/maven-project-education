package task2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        /*Boss hugoBoss = new Boss("Victor", 40, 1000, 30, 0, 10.5);
        System.out.println(hugoBoss.tellAccountantFactorForBonus(5));*/
        LabourMarket labourMarket = new LabourMarket();
        List<HR> hrs = labourMarket.provideEmployee(1, HR.class);
        HR hr = hrs.get(0);
        hr.labourMarket = labourMarket;
        Manager manager = hr.hireEmployee(Manager.class); // TODO: вот для чего это делалось а чтобы у тебя больше не возникало желяния использовать лайфхаки типа {} я кое что добавлю.

        manager.setName(manager.name);
        manager.setAge(manager.age);
        manager.setRate(manager.rate);
        manager.setOvertimeHours(manager.overtimeHours);
        manager.setWorkingHours(manager.workingHours);
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(manager);
        System.out.println(result);
        // TODO: 4/1/20 твой джейсон великолепен, но если ты хочешь погрузится в сериализацию, то не стоит останавливать себя от десериализации, сделай объект на основании своего джейсона через маппер.




        /*Random random = new Random();
        // TODO: 3/21/20 рунок труда можно передать ХРу в конструктор например или отдельным методом
        Office office = new Office();
        Meteorologist meteorologist = new Meteorologist();

        List<Accountant> accountants = labourMarket.provideEmployee(4, Accountant.class); // TODO: 3/21/20 получаем 3 готовых бухгалтера
        List<Manager> managers = labourMarket.provideEmployee(1, Manager.class);// TODO: 3/21/20 получаем 1 менеджера

        List<HR> hrs = labourMarket.provideEmployee(1, HR.class);
        HR hr = hrs.get(0);
        hr.labourMarket = labourMarket;
        office.hr = hr;*/





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
