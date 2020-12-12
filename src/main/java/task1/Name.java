package task1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


import java.util.Objects;
import java.util.Random;


@JsonAutoDetect
public class Name {

    String firstName;
    String lastName;
    public static final String[] fnames = {"Иван", "Григорий", "Василий", "Эдди", "Сергей", "Александр", "Роланд", "Стивин", "Виктор", "Томас", "Айзек", "Шон", "Стьюи", "Питер", "Браен"};
    public static final String[] lnames = {"Паршин", "Иванов", "Анхимов", "Быков", "Вихров", "Артёмов", "Фёдоров", "Аркадьев", "Гришин", "Хрусталёв", "Азимов", "Бин", "Гриффин", "Паркер"};


    public Name(String name) {
        String[] split = name.split(" ");
        this.firstName = split[0];
        this.lastName = split[1];
    }

    public Name() {
        Random random = new Random();
        this.firstName = fnames[random.nextInt(fnames.length)];
        this.lastName = lnames[random.nextInt(lnames.length)];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) &&
                Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
