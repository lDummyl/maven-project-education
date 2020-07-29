package task1;

import java.time.LocalDate;
import java.util.Random;

public class Birthday {

    public static final int MAX_AGE_YEARS = 60;
    int year;
    int month;
    int day;


    public Birthday(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

//    @Override
//    public String toString() {
//        return "Birthday{" +
//                "year=" + year +
//                ", month=" + month +
//                ", day=" + day +
//                '}';
//    }

    public Birthday() {
        LocalDate localDate = null;
        while (localDate == null) {
            Random random = new Random();
            year = 1960 + random.nextInt(MAX_AGE_YEARS);
            month = 1 + random.nextInt(12);
            day = 1 + random.nextInt(31);
            try {
                localDate = LocalDate.of(year, month, day);
            } catch (Exception e) {
                System.out.println("Invalid date was generated " + year + " " + month + " " + day);
            }

        }
    }

    public static void main(String[] args) {
        Birthday birthday = new Birthday();
//        System.out.println(birthday);
    }

    public boolean after(Birthday birthday) {
        LocalDate thisBirthday = LocalDate.of(this.year, this.month, this.day);
        LocalDate currBirthday = LocalDate.of(birthday.year, birthday.month, birthday.day);
        return thisBirthday.isAfter(currBirthday);
    }
}
//	public Name() {
//		firstName = names.get(random.nextInt(names.size()));
//		lastName = lastNames.get(random.nextInt(lastNames.size()));
//	}
//}