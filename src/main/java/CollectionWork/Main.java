package CollectionWork;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        TreeSet<Wanderer> wanderers = new TreeSet<>();
        ArrayList<Wanderer> wanderers1 = new ArrayList<>();
        ArrayList<Wanderer> wanderers2 = new ArrayList<>();


        wanderers = generator.treePersonGenerator();
        wanderers1 = generator.arrayPersonGenerator(22977);
        wanderers2 = generator.uniArrayPersonGenerator(22977);

    }
}
