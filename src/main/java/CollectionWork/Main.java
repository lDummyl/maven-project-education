package CollectionWork;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        TreeSet<Person> tree = generator.treePersonGenerator(1000);
        System.out.println(tree.size());

    }
}
