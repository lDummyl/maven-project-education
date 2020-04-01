package task2;

import java.util.Random;

public class Employee extends Person {
    private int rate;
    private int workingHours;
    private int overtimeHours;

    public Employee(String name, int age, int rate, int workingHours, int overtimeHours) {
        super(name, age);
        this.rate = rate;
        this.workingHours = workingHours;
        this.overtimeHours = overtimeHours;
    }

    public Employee() {
    }

    public int getRate() {
        return rate;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    static int tellAccountantQuantityOfWorkingDays() { // сказать количество рабочих дней за месяц
        Random random = new Random();
        int quantityOfWorkingDays = random.nextInt(22);

        return quantityOfWorkingDays;
    }

    static int tellAccountantQuantityOfOvertimeInHours() { // //сказать количество часов с переработкой
        Random random = new Random();
        int quantityOfOvertimeHours = random.nextInt(20);

        return quantityOfOvertimeHours;
    }

    static int getRatePerHour() {  //получить ставку в руб./час за сотрудника
        Random random = new Random();
        return random.nextInt(1500);
    }

  /*  Employee(String name, int age, int rate, int workingHours, int overtimeHours){
        //super(name, age);
        this.name = name;
        this.age = age;
        this.rate = rate;
        this.workingHours = workingHours;
        this.overtimeHours = overtimeHours;
    }*/

    @Override
    public String toString() {
        return "Name{" +
                name + '\'' +
                ", rate='" + rate + '\'' + ", workingHours= " + workingHours + '\'' + ", overtimeHours= " + overtimeHours +
                '}';
    }

    @Override
    public void tellWhatYouDoForALiving() {
        System.out.println("");
    }
}
