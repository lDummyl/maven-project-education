package task2;

public class SecurityOfficer implements WantAJob {

    private final String name;
    private boolean employed = false;

    public SecurityOfficer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
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
        return "SecurityOfficer{" +
                "name='" + name + '\'' +
                ", employed=" + employed +
                '}';
    }
}
