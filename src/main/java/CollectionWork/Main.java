package CollectionWork;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        FullTime fullTime = new FullTime();

        fullTime.getTime(100);
        fullTime.getTime(1000);
        fullTime.getTime(10000);
        fullTime.getTime(22977);
        fullTime.getTime(100000);
    }
}
