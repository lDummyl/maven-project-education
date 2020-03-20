package task2;

import lombok.NonNull;

public class Office {

    Boss boss;
    Accountant accountant;
    Employee employee;
    HR hr;

    void assign(HR hr) {
        this.hr = hr;
        System.out.println("Меня зовут: " + hr.name);
    }

    void assign(Boss boss) {
        this.boss = boss;
        System.out.println("\nМеня зовут: " + boss.name);
    }

    void startWorkingDay() {
        everybodyDrinksCoffee();
        hireEmployee();
        giveBonus();
        doRegularWork();
        checkBirthdays();
        callCustomers();
        boss.goToBathroom();
        doRegularWork();
        hr.fireEmployee();
        haveLunch();
        doRegularWork();
        takeBreak();
        procrastinate();
        finishWorkingDay();
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
    }

    private void everybodyDrinksCoffee() {
    }

}
