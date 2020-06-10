package task2.Aquarium;

public class Food {
    String name;
    int count = 20;

    public Food(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                '}';
    }
}
