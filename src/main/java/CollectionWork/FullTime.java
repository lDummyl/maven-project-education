package CollectionWork;

import java.util.ArrayList;
import java.util.TreeSet;

public class FullTime {
    public void getTime(int arraySize) {
        SearchTimer searchTimer = new SearchTimer();
        Generator generator = new Generator();

        if (arraySize < 22977) {
            TreeSet<Wanderer> wanderers1 = generator.treePersonGenerator(arraySize);
            searchTimer.getTreeTime(wanderers1);
        }
        ArrayList<Wanderer> wanderers2 = generator.arrayPersonGenerator(arraySize);
        ArrayList<Wanderer> wanderers3 = generator.uniArrayPersonGenerator(arraySize);

        searchTimer.getArraySortTime(wanderers2);
        searchTimer.getArraySearchTime(wanderers3);
        System.out.println("///////////////////");
    }
}
