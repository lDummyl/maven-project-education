package task2;

public class Secretary implements WantAJob {

    private final String name;
    private boolean employed = false;

    public Secretary(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public Coffee getCoffee(String sort) {
        return new Coffee(sort);
    }

    @Override
    public Boolean passInterview() {
        return true;
    }

    @Override
    public Boolean isEmployed() {
        return employed;
    }

    @Override
    public Boolean makeDecision() {
        return true;
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "name='" + name + '\'' +
                ", employed=" + employed +
                '}';
    }
}
