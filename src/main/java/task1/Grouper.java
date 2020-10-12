package task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grouper {
    public static void main(String[] args) {
        AnimalProvider animalProvider = new AnimalProvider();
        Pet kitten = animalProvider.getPet(Kitten.class);
        Pet kitten1 = animalProvider.getPet(Kitten.class);
        Pet kitten2 = animalProvider.getPet(Kitten.class);
        Pet dog = animalProvider.getPet(Dog.class);
        Pet dog1 = animalProvider.getPet(Dog.class);
        Pet dog2 = animalProvider.getPet(Dog.class);
        Class<?> aClass = kitten.getClass();
        HashMap<Class <?>, List> map = new HashMap<>();
        ArrayList<Object> list = new ArrayList<>();
        list.add(kitten);
        list.add(kitten1);
        list.add(kitten2);
        map.put(aClass, list);
        Class <?> dogClass = dog.getClass();
        ArrayList<Object> listOfDogs = new ArrayList<>();
        listOfDogs.add(dog);
        listOfDogs.add(dog1);
        listOfDogs.add(dog2);
        map.put(dogClass, listOfDogs);
        for (Map.Entry<Class<?>, List> classListEntry : map.entrySet()) {
            Class key = classListEntry.getKey();
            List value = classListEntry.getValue();
            System.out.println(key + " " + value);

        }
    }
}

class Pet
{
    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    String name;
    int age;
    int weight;

    public Pet(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}

class Kitten extends Pet{


    public Kitten(String name, int age, int weight) {
        super(name, age, weight);
    }
}
class Dog extends Pet
{

    public Dog(String name, int age, int weight) {
        super(name, age, weight);
    }
}