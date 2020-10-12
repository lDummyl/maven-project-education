package task1;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AnimalProvider {
    String name;
    int age;
    int weight;

    List<String> listOfCatNames = Arrays.asList("Мурка", "Пушок", "Маркиз","Лео", "Барсик");
    List<String> listOfDogNames = Arrays.asList("Рекс", "Буч", "Мухтар", "Джек", "Шарик");

    public <T extends Pet> Pet getPet (Class<T> tClass)
    {
        if (tClass.equals(Kitten.class))
        {
        Random random = new Random();
            name = listOfCatNames.get(random.nextInt(listOfCatNames.size()));
            age = random.nextInt(12);
            weight = random.nextInt(10);
            return new Kitten(name, age, weight);
        }
        else if (tClass.equals(Dog.class)) {
            Random random = new Random();
            name = listOfDogNames.get(random.nextInt(listOfDogNames.size()));
            age = random.nextInt(15);
            weight = random.nextInt(20);
            return new Dog(name, age, weight);
        }
        return null;
    }
}
