package task2;

public class Office {

    Boss boss;
    Accountant accountant;
    Employee employee;
    HR hr;

    void work(Accountant accountant){
        this.accountant = accountant;
    }

    void work(Boss boss){
        this.boss = boss;
    }

    void work(HR hr){
        this.hr = hr;
    }

    void work(Employee employee){
        this.employee = employee;
    }


}
