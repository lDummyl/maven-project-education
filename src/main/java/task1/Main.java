package task1;



import java.util.*;

public class Main {

    static List<String> firstN = new ArrayList<>();
    static Random random = new Random();
    public static final int DAY = 30;
    public static final int MONTH = 12;
    public static final int YEAR = 80;

    static {
        firstN.add("Ivan");
        firstN.add("Oleg");
        firstN.add("Nikita");
        firstN.add("Roman");
        firstN.add("Nikolay");
        firstN.add("Dmitry");
        firstN.add("Alexander");
        firstN.add("Stanislav");
        firstN.add("Konstantin");
        firstN.add("Sergey");
    }

    static List<String> lastN = new ArrayList<>();

    static {
        lastN.add("Ivanov");
        lastN.add("Smirnov");
        lastN.add("Sidorov");
        lastN.add("Petrov");
        lastN.add("Vodkin");
        lastN.add("Nikitin");
        lastN.add("Orlov");
        lastN.add("Kruglov");
        lastN.add("Jiglov");
        lastN.add("Djigurda");
    }

    public static void main(String[] args) {
        first();
        second();


    }

    public static Person searchOldest(List<Person> people) {
        List<Date> dates = new ArrayList<>();

        int index = 0;
        for (Person p : people) {
            dates.add(new Date(people.get(index).getAge().getYear(),
                    people.get(index).getAge().getMonth() - 1,
                    people.get(index).getAge().getDay()));
            index++;
        }
        int old = 0;
        for (int i = 0; i < dates.size() - 1; i++) {
            int compare = dates.get(old).compareTo(dates.get(i + 1));
            if (compare == 1) {
                old = i + 1;
            }
        }
        return people.get(old);
    }

    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего

        // TODO: 5/13/20 Hithere!
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(new Name("Fedor", "Ivanov"), new Age(15, 1, 1967)));
        personList.add(new Person(new Name("Egor", "Smirnov"), new Age(23, 9, 1952)));
        personList.add(new Person(new Name("Vadim", "Petrov"), new Age(1, 12, 1999)));
        personList.add(new Person(new Name("Semen", "Sidorov"), new Age(30, 5, 2016)));
        personList.add(new Person(new Name("Igor", "Petrenko"), new Age(7, 7, 1963)));

        System.out.println(searchOldest(personList));


    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.


        List<Person> personList2 = new ArrayList<>();

        personList2.addAll(getSomePerson(20));
        System.out.println(personList2);
        System.out.println(searchOldest(personList2));


    }

    private static Person getSomePerson() {
        return new Person(new Name(firstN.get(random.nextInt(firstN.size())), lastN.get(random.nextInt(lastN.size()))),
                new Age(random.nextInt(30)+1, random.nextInt(12)+1, random.nextInt(80)+1940));
    }
    private static List<Person> getSomePerson(int j) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < j; i++) {
            list.add(new Person(new Name(firstN.get(random.nextInt(firstN.size())), lastN.get(random.nextInt(lastN.size()))),
                    new Age(random.nextInt(30)+1, random.nextInt(12)+1, random.nextInt(80)+1940)));
        }

        return list;
    }

}

class Name {

    String firstName;
    String lastName;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

class Age {

    int year;
    int month;
    int day;

    Age(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }
}

class Person {

    Name name;
    Age age;

    Person(Name name, Age age) {
        this.name = name;
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }
}