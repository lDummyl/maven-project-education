package task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grouper {
    public static void main(String[] args) {
        AnimalProvider animalProvider = new AnimalProvider();
        Kitten kitten = animalProvider.getCat();
        Kitten kitten1 = animalProvider.getCat();
        Kitten kitten2 = animalProvider.getCat();
        Dog dog = animalProvider.getDog();
        Dog dog1 = animalProvider.getDog();
        Dog dog2 = animalProvider.getDog();
        Class<?> aClass = kitten.getClass();
        HashMap<Class <?>, List> map = new HashMap<>();
        ArrayList<Object> list = new ArrayList<>();
        list.add(kitten);
        list.add(kitten1);
        list.add(kitten2);
        map.put(Kitten.class, list);
        Class <?> dogClass = dog.getClass();
        ArrayList listOfDogs = new ArrayList();
        listOfDogs.add(dog);
        listOfDogs.add(dog1);
        listOfDogs.add(dog2);
        map.put(dogClass, listOfDogs);
        System.out.println(dog);
        for (Map.Entry<Class<?>, List> classListEntry : map.entrySet()) {
            System.out.println(classListEntry.getValue());
        }
    }
}
class Pet
{
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