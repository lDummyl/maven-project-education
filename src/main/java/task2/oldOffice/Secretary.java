package task2.oldOffice;

public class Secretary {

    public double kpi;
    public int experienceYears;
    String name;

    public Secretary(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "name='" + name + '\'' +
                '}';
    }
}

