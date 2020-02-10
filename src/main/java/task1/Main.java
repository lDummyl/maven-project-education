package task1;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        first();
        //	second();

    }

    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего

        Age age0 = new Age(1902, 02, 10);   //ребенок
        Name name0 = new Name("Olga ", "Petrova");
        Person person0 = new Person(name0, age0);

        Age age1 = new Age(1902, 02, 10);   //отец
        Name name1 = new Name("Victor ", "Nabokov");
        Person person1 = new Person(name1, age1);

        Age age2 = new Age(1956, 01, 10);   //ребенок
        Name name2 = new Name("Misha ", "Sidorov");
        Person person2 = new Person(name2, age2);

        Age age3 = new Age(1984, 01, 10);   //ребенок
        Name name3 = new Name("Anna ", "Ivanova");
        Person person3 = new Person(name3, age3);

        Age age4 = new Age(1984, 01, 10);   //ребенок
        Name name4 = new Name("Maria", "Torova");
        Person person4 = new Person(name4, age4);

        ArrayList<Person> people = new ArrayList<Person>() {{
            add(person0);
            add(person1);
            add(person2);
            add(person3);
            add(person4);
        }};

        for (Person peopleCounter : people) {
            System.out.println("Количество дней от 1900: " + peopleCounter.age.fullYearToDays() + "       Имя: " + peopleCounter.name);
        }

        int minDays = 1000000;

        for (Person person : people) {
            if (person.age.fullYearToDays() < minDays) { // находим минимальное кол-во дней
                minDays = person.age.fullYearToDays();
            }
        }

        for (Person person : people) {
            if (person.age.fullYearToDays() == minDays) {
                System.out.println("Наибольший возраст: " + person.name + person.age.fullYearToDays());
            }
        }
    }


    // TODO: 2/3/20 теперь старший это быдет отец, у которого должна быть коллекция всех детишек(все кто младше него). За исключением тех кто того же возраста
    //  они должны дратся несмерть и there can be only one т.е. Падшие воены в список детей не попадают. А каждому ребенку проставляется отец. Создай новый класс
    //  для этого, он будет наследвоать Person и включать новые поля List<Person> children и Person parent.

    // TODO: 2/3/20 или просто создай 10 животных в классе universe. Причем чтобы была как минимум тройная вложенность(хотябы в одном случае) ну и поведение и свойства соответсвующие.


    public static void second() {
        //  TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.
        Name name0 = new Name("Olga ", "Petrova");
        Name name1 = new Name("Victor ", "Nabokov");
        Name name2 = new Name("Semen ", "Ylyich");

        Age age0 = new Age(1995, 06, 12);
        Age age1 = new Age(1994, 05, 11);
        Age age2 = new Age(1993, 04, 10);

        List<Name> names = Arrays.asList(name0, name1, name2);
        List<Age> ages = Arrays.asList(age0, age1, age2);
        ArrayList<Person> randomPersons = new ArrayList();

        Random random = new Random();

        for (int i = 0; i < names.size(); i++) {
            Name name = names.get(random.nextInt(names.size()));
            Age age = ages.get(random.nextInt(ages.size()));

            Person person = new Person(name, age);
            randomPersons.add(person);

        }
        System.out.println(randomPersons.toString());
    }

}

class Name {

    String firstName;
    String lastName;

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

class Age {

    int year;
    int month;
    int day;

    @Override
    public String toString() {
        return "Age{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }

    Age(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    int fullYearToDays() {
        int[] daysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int counter1 = 0;
        int counter2 = 0;
        int daysResult = 0;

        for (int i = 1900; i <= year; i++) { // подсчет дней за каждый месяц

            boolean isLeapYear = (i % 4 == 0) && (i % 100 != 0 || i % 400 == 0); // учет високосного года

            if (i != year) {
                for (int j = 0; j < daysInMonths.length; j++) {
                    if (isLeapYear) {
                        daysInMonths[1] = 29;
                    }
                    counter1 = counter1 + daysInMonths[j];  // подсчет дней за  год
                }
            }

            if (i == year) {
                for (int k = 0; k < month - 1; k++) {
                    if (isLeapYear) {
                        daysInMonths[1] = 29;
                    }
                    counter2 = counter2 + daysInMonths[k];  // подсчет дней за остаточный месяц
                }
            }
            daysResult = counter1 + counter2 + day; // суммарный подсчет от 1900 до даты рождения

        }
        return daysResult;
    }
}

class Person {

    Name name;
    Age age;

    Person(Name name, Age age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
