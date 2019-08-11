package task2;

public class SecurityOfficer implements WantAJob {

    private final String name;

    public SecurityOfficer(String name) {
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
        return "SecurityOfficer{" +
                "name='" + name + '\'' +
                '}';
    }
}
