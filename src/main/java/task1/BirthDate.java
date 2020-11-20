package task1;

import java.util.Random;

public class BirthDate {

    int day;
    int month;
    int year;

    static Random random = new Random();

    public BirthDate(int bottomYear) {
        day = 1 + random.nextInt(30);
        month = 1 + random.nextInt(11);
        year = bottomYear - random.nextInt(100);
    }

    public boolean before(BirthDate other) {
        if (year < other.year) {
            return true;
        } else if (year == other.year && month < other.month) {
            return true;
        } else return  (year == other.year && month == other.month && day < other.day);
    }
}
