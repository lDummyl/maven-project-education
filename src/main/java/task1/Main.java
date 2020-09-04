package task1;


import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        first();
        second();

    }

    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего

        int oldest = 0;

        Person person = new Person("Иван Иванов", 20, 11, 1945);
        Person person2 = new Person("Григорий Зуев", 14, 9, 1911);
        Person person3 = new Person("Степан Трешков", 4, 8, 1993);
        Person person4 = new Person("Виктор Триванов", 10, 6, 1964);
        Person person5 = new Person("Ник Теренов", 10, 6, 1911);

        ArrayList<Person> list = new ArrayList<Person>();
        list.add(person);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);

        int min = list.get(0).birthDate.day + list.get(0).birthDate.month * 30 + list.get(0).birthDate.day * 365;

        ArrayList<Integer> days = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            days.add(list.get(i).birthDate.day + list.get(i).birthDate.month * 30 + list.get(i).birthDate.day * 365); //Работает без учёта дней в месмяце и высокосности годов
        }
        for (int i = 0; i < list.size(); i++) {
            if (days.get(i) < min) {
                min = days.get(i);
                oldest = i;
            }
        }

        //System.out.println(days);

        // TODO: 9/3/20 Hi there!

        System.out.println(list.get(oldest).name.firstName);
    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.
        ArrayList<String> names = new ArrayList<>();
        names.add("Виктор Паршин");
        names.add("Сергей Путнов");
        names.add("Эдди Дин");
        names.add("Родланд Дискейн");
        names.add("Джон Торин");
        final Random random = new Random();
        for (int i = 0; i < names.size(); i++) {

            new Person(names.get(random.nextInt(names.size())), random.nextInt(31), random.nextInt(12), random.nextInt());
        }
    }

}

class Name {

    String firstName;
    String lastName;

    public Name(String name) {
        String[] split = name.split(" ");
        this.firstName = split[0];
        this.lastName = split[1];
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class BirthDate {

    int year;
    int month;
    int day;

    public BirthDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}

class Person {
    public Person(Name name, int day, int month, int year) {
        this.name = name;
        this.birthDate = new BirthDate(day, month, year);
    }

    Name name;
    BirthDate birthDate;


    public Person(String name, int day, int month, int year) {
        String[] split = name.split(" ");
        this.birthDate = new BirthDate(day, month, year);
        this.name = new Name(split[0], split[1]);
    }

}