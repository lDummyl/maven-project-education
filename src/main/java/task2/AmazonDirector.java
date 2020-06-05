package task2;

import task1.Person;

import java.util.HashSet;

public class AmazonDirector extends Director {
    String name;
    int maxQuantityOfStuff;

    public AmazonDirector(String name, int maxQuantityOfStuff) {
        super(name, maxQuantityOfStuff);
        this.name = name;
        this.maxQuantityOfStuff = maxQuantityOfStuff;
    }
    public HashSet<Person> makeChoice(){
        HashSet<Person> set = (HashSet<Person>) new Hr("")
                .selectedPeople(maxQuantityOfStuff);
        System.out.println(set);
        return set;
    }
}
