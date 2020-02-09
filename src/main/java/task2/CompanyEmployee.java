package task2;

public abstract class CompanyEmployee {
    String name;

    public CompanyEmployee(String name) {
        this.name = name;
    }

    public abstract boolean passInterview();

}
