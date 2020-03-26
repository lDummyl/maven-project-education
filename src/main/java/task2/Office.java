package task2;

import java.util.Scanner;

public class Office {

    Boss boss;
    Accountant accountant;
    Security security;
    Employee employee;
    HR hr;
    Meteorologist meteorologist;

    void assign(HR hr) {
        this.hr = hr;
        System.out.println("Меня зовут: " + hr.name);
    }

    void assign(Boss boss) {
        this.boss = boss;
        System.out.println("\nМеня зовут: " + boss.name);
    }

    String inputDayOfWeek(){
        System.out.println("Введите день недели на англ: ");
        Scanner input = new Scanner(System.in);
        String day = input.nextLine();

        return day;
    }
    void startWorkingDay(String inputDayOfWeek) throws Exception {
        // TODO: 3/21/20 работаем или выходной if(dayOfWeek...){

//        if(DayOfWeek.SUNDAY || DayOfWeek.SATURDAY) {
//            System.out.println("Weekend");
//
//        else {
            everybodyDrinksCoffee();
            hireEmployee();
            giveBonus();
        //    meteorologist.getWeather();
            doRegularWork();
            checkBirthdays();
            callCustomers();
            boss.goToBathroom();
            doRegularWork();
            fireEmployee();
            haveLunch();
            doRegularWork();
            takeBreak();
            procrastinate();
            finishWorkingDay();
  //      }
    }

    private void fireEmployee() {
        if (imIToOldForThisShit(accountant)){
            accountant = null;
        }
        // TODO: 3/21/20 и так далее

    }

    private boolean imIToOldForThisShit(Employee employee) {
        // TODO: 3/21/20 придумай  if (employee)
        if (employee.age > 65 ){
            System.out.println("Fuck you all, I'm resigning!");
        }

        return false;

    }

    private void finishWorkingDay() {
    }

    private void takeBreak() {
    }

    private void procrastinate() {
    }

    private void haveLunch() {
    }


    private void callCustomers() {
    }

    private void checkBirthdays() {
        if(somebodyHasBirthday()){
            celebrateBirthday();
        }
    }

    private boolean somebodyHasBirthday() {

        return true;
    }

    private void celebrateBirthday() {
    }

    private void doRegularWork() {
    }

    private void giveBonus() {
    }

    private void hireEmployee() {
        if (accountant == null){
            accountant = hr.hireEmployee(Accountant.class);
        }
        if (security == null){
            // TODO: 3/21/20  и так далее
        }


    }

    private void everybodyDrinksCoffee() {
    }

}
