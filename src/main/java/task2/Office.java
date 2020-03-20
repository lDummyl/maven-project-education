package task2;

public class Office {

    Boss boss;
    Accountant accountant;
    Security security;
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

    void startWorkingDay(DayOfWeek dayOfWeek) {
        // TODO: 3/21/20 работаем или выходной if(dayOfWeek...){



        everybodyDrinksCoffee();
        hireEmployee();
        giveBonus();
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
    }

    private void fireEmployee() {
        if (imIToOldForThisShit(accountant)){
            accountant = null;
        }
        // TODO: 3/21/20 и так далее

    }

    private boolean imIToOldForThisShit(Employee employee) {
        // TODO: 3/21/20 придумай  if (employee)
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
