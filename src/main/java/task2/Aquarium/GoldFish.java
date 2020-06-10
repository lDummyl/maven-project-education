package task2.Aquarium;

public class GoldFish extends Fish {
    String name;

    public GoldFish(String name) {
        this.name = name;
    }

    @Override
    public void likeToEat(Food food) {
        System.out.println("I don't like to eat " + food);
    }

    @Override
    public String toString() {
        return "GoldFish{" +
                "name='" + name + '\'' +
                '}';
    }
}
