package task2.Aquarium;

public class BlueFish extends Fish {

    String name;

    public BlueFish(String name) {
        this.name = name;
    }


    @Override
    public void likeToEat(Food food) {
        System.out.println("I like to eat " + food);
    }

    @Override
    public String toString() {
        return "BlueFish{" +
                "name='" + name + '\'' +
                '}';
    }

}
