package task2;

public class Accountant implements WantAJob {

    private final String name;

    public Accountant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Boolean passInterview() {
        return true;
    }

    @Override
    public String toString() {
        return "Accountant{" +
                "name='" + name + '\'' +
                '}';
    }
}
