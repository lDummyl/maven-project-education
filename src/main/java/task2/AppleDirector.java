package task2;

import task1.Person;

import java.util.HashSet;

public class AppleDirector extends Director {
    String name;
    int maxQuantityOfStuff;

    public AppleDirector(String name, int maxQuantityOfStuff) {
        super(name, maxQuantityOfStuff);
        this.name = name;
        this.maxQuantityOfStuff = maxQuantityOfStuff;

    }

    public HashSet<Person> makeChoice() {
        HashSet<Person> set = (HashSet<Person>) new Hr("")
                .selectedPeople(maxQuantityOfStuff);
        while (maxQuantityOfStuff>5){
            System.out.println("Those people weren't good! I need a new list!!");
            set = (HashSet<Person>) new Hr("")
                    .selectedPeople(maxQuantityOfStuff);
        }
        System.out.println(set);
        return set;
    }
}


