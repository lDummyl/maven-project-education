package CollectionWork;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeSet;

public class FullTime {
    public void getTime(int maxArraySize, int minArraySize, int step) {
        SearchTimer searchTimer = new SearchTimer();
        Generator generator = new Generator();

        for (int i = minArraySize; i < maxArraySize; i += step) {

            LocalDateTime from = LocalDateTime.now();
            generator.treePersonGenerator(i);
            LocalDateTime to = LocalDateTime.now();
            Duration between = Duration.between(from, to);
            System.out.println("Время генерации дерева: " + between + "количество элементов: " + i);

            LocalDateTime from2 = LocalDateTime.now();
            generator.uniArrayPersonGenerator(i);
            LocalDateTime to2 = LocalDateTime.now();
            Duration between2 = Duration.between(from, to);
            System.out.println("Время генерации уникального ArrayList: " + between2 + "количество элементов: " + i);

            LocalDateTime from3 = LocalDateTime.now();
            generator.arrayPersonGenerator(i);
            LocalDateTime to3 = LocalDateTime.now();
            Duration between3 = Duration.between(from, to);
            System.out.println("Время генерации не уникального ArrayList: " + between3 + "количество элементов: " + i);
            System.out.println("_______________________");
        }


    }
}
