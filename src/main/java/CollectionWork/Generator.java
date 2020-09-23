package CollectionWork;

import java.util.TreeSet;

public class Generator {
    public TreeSet<Human> treePersonGenerator(int treeSize) {
        TreeSet<Human> people = new TreeSet<>();

        while (people.size() < treeSize) {

            people.add(new Human());
            System.out.println(people.size());
        }
        return people;
    }
}
