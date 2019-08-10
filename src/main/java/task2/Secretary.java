package task2;

public class Secretary implements WantAJob{
    private String name;

    public Secretary(String name) {
        this.name = name;
    }

    @Override
    public Boolean passInterview() {
        return true;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "name='" + name + '\'' +
                '}';
    }
}
