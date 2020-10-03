package CollectionWork;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class FullTime {
    public void getTime(int maxArraySize, int minArraySize, int step) {
        SearchTimer searchTimer = new SearchTimer();
        Generator generator = new Generator();
        ReportWriter reportWriter = new ReportWriter();

        for (int i = minArraySize; i < maxArraySize; i += step) {

            ArrayList<Timer> timers = new ArrayList<>();
            ArrayList<Timer> search_timers = new ArrayList<>();


            LocalDateTime from = LocalDateTime.now();
            TreeSet<Wanderer> wanderers = generator.treePersonGenerator(i);
            LocalDateTime to = LocalDateTime.now();
            Duration between = Duration.between(from, to);

            search_timers.add(new Timer("TreeSearch",i,searchTimer.getTreeTime(wanderers)));

            timers.add(new Timer("Tree", i, between));

            LocalDateTime from2 = LocalDateTime.now();
            ArrayList<Wanderer> wanderers1 = generator.uniArrayPersonGenerator(i);
            LocalDateTime to2 = LocalDateTime.now();
            Duration between2 = Duration.between(from2, to2);

            searchTimer.getArraySearchTime(wanderers1);
            searchTimer.getArraySortTime(wanderers1);
            search_timers.add(new Timer("ArraySearch",i,searchTimer.getArraySearchTime(wanderers1)));
            search_timers.add(new Timer("ArraySort",i,searchTimer.getArraySortTime(wanderers1)));
            timers.add(new Timer("UniArray", i, between2));

            LocalDateTime from3 = LocalDateTime.now();
            generator.arrayPersonGenerator(i);
            LocalDateTime to3 = LocalDateTime.now();
            Duration between3 = Duration.between(from3, to3);
            timers.add(new Timer("NoUniArray", i, between3));

            Collections.sort(timers);
            Collections.sort(search_timers);

            reportWriter.writeReport("Время генерации в порядке возрастания");
            for (Timer t : timers) {
                reportWriter.writeReport("Тип-" + t.type + "Размер-" + t.size + "Время генерации" + t.timeToAdd);
            }
            reportWriter.writeReport("");

            reportWriter.writeReport("Время поиска в порядке возрастания");

            for (Timer t : search_timers) {
                reportWriter.writeReport("Тип-" + t.type + "Размер-" + t.size + "Время поиска" + t.timeToAdd);
            }
            reportWriter.writeReport("");
        }
    }
}
