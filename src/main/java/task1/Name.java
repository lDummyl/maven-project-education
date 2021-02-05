package task1;




import lombok.*;

import java.util.Random;

@Generated
@Setter
@Getter
@EqualsAndHashCode
public class Name {

    private String firstName;
    private String lastName;
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

}
