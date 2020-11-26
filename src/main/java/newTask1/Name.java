package newTask1;

import java.util.Random;

public class Name {
    String firstName;
    String lastName;
    Random random =  new Random();

    public static final String[] fnames = {"Иван", "Григорий", "Василий", "Эдди", "Сергей", "Александр", "Роланд", "Стивин", "Виктор", "Томас", "Айзек", "Шон", "Стьюи", "Питер", "Браен"};
    public static final String[] lnames = {"Паршин", "Иванов", "Анхимов", "Быков", "Вихров", "Артёмов", "Фёдоров", "Аркадьев", "Гришин", "Хрусталёв", "Азимов", "Бин", "Гриффин", "Паркер"};


    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name() {
      this.firstName = fnames[random.nextInt(fnames.length)];
      this.lastName = lnames[random.nextInt(lnames.length)];
    }
}
