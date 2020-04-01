package task2;

public class Manager extends Employee {


     Manager(String name, int age, int rate, int workingHours, int overtimeHours) {
        super(name, age, rate, workingHours, overtimeHours);
    }

    public Manager() {
    }

    void speakByPhone(){
        System.out.println("Bla-bla-bla");
    }
}
