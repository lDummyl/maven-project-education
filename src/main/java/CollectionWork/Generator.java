package CollectionWork;

import java.util.TreeSet;

public class Generator {
    public TreeSet<Person> treePersonGenerator(int treeSize){
        TreeSet<Person> people = new TreeSet<>();

        while (people.size()<treeSize){
            people.add(new Person());
            System.out.println(people.size());
        }
        return people;
    }
}
