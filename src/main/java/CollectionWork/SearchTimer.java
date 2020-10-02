package CollectionWork;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class SearchTimer {
    public Duration getTreeTime(TreeSet<Wanderer> tree) {
        LocalDateTime from = LocalDateTime.now();
        System.out.println(tree.first());
        LocalDateTime to = LocalDateTime.now();
        Duration between = Duration.between(from, to);
       return between;
    }

    public Duration getArraySortTime(ArrayList<Wanderer> list) {
        LocalDateTime from = LocalDateTime.now();
        Collections.sort(list);
        System.out.println(list.get(0));
        LocalDateTime to = LocalDateTime.now();
        Duration between = Duration.between(from, to);
        return between;
    }

    public Duration getArraySearchTime(ArrayList<Wanderer> list) {
        Wanderer min = list.get(0);
        LocalDateTime from = LocalDateTime.now();

        for (Wanderer w : list) {
            if (w.compareTo(min) == -1) {
                min = w;
            }
        }
        System.out.println(min);
        LocalDateTime to = LocalDateTime.now();
        Duration between = Duration.between(from, to);
        return between;
    }

}
