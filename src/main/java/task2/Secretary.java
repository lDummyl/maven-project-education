package task2;

public class Secretary implements WantAJob {

    private final String name;

    public Secretary(String name) {
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
        return "Secretary{" +
                "name='" + name + '\'' +
                '}';
    }
}
