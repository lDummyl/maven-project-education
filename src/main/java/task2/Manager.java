package task2;

public class Manager extends Employee {
    String name;
    int age;
    int rate;
    int workingHours;
    int overtimeHours;

    Manager(String name, int age, int rate, int workingHours, int overtimeHours) {
        super(name, age, rate, workingHours, overtimeHours);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    void speakByPhone(){
        System.out.println("Bla-bla-bla");
    }
}
