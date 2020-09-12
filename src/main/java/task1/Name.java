package task1;

import java.util.Random;
import java.util.UUID;

public class Name {

    String firstName;
    String lastName;
    public static final String[] fnames = {"Иван", "Григорий", "Василий", "Эдди", "Сергей", "Александр", "Роланд", "Стивин", "Виктор", "Томас", "Айзек"};
    public static final String[] lnames = {"Паршин", "Иванов", "Анхимов", "Быков", "Вихров", "Артёмов", "Фёдоров", "Аркадьев", "Гришин", "Хрусталёв", "Азимов"};


    public Name(String name) {
        String[] split = name.split(" ");
        this.firstName = split[0];
        this.lastName = split[1];
    }

    public Name() {
        Random random = new Random();
        this.firstName = fnames[random.nextInt(fnames.length)];
        this.lastName = lnames[random.nextInt(lnames.length)];

        //this.firstName = (UUID.randomUUID()).toString();
        //this.lastName = (UUID.randomUUID()).toString();
    }
}
