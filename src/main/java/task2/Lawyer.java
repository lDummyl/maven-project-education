package task2;

public class Lawyer implements WantAJob {

    private final String name;

    public Lawyer(String name) {
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
        return "Lawyer{" +
                "name='" + name + '\'' +
                '}';
    }
}
