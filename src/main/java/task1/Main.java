package task1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Task1:
        ArrayList<Person> people = createPersons();
        outputGeneralListWithNamesAndNumbersOfDaysFrom1900(people);
        findMaxAge(people);
        int minDays = findMaxAge(people);
        ArrayList<Person> peopleWithMaxAge = outputPersonsWithMaxAge(minDays, people);
        System.out.println("Наибольший возраст: " + peopleWithMaxAge);
        System.out.println(chooseOneParent(outputPersonsWithMaxAge(minDays, people)));

        //Task2:
        createListOfRandomPersons();
    }


    public static ArrayList<Person> createPersons() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего

        Age age0 = new Age(1902, 02, 10);   //ребенок
        Name name0 = new Name("Olga ", "Petrova");
        Person person0 = new Person(name0, age0);

        Age age1 = new Age(1956, 02, 10);   //отец
        Name name1 = new Name("Victor ", "Nabokov");
        Person person1 = new Person(name1, age1);

        Age age2 = new Age(1902, 02, 10);   //ребенок
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

        return people;
    }

    public static void outputGeneralListWithNamesAndNumbersOfDaysFrom1900(ArrayList<Person> people) {
        for (Person peopleCounter : people) {
            System.out.println("Количество дней от 1900: " + peopleCounter.age.fullYearToDays() + "       Имя: " + peopleCounter.name);
        }
    }

    public static int findMaxAge(ArrayList<Person> people) {
        int minDays = 1000000;

        for (Person person : people) {
            if (person.age.fullYearToDays() < minDays) { // находим минимальное кол-во дней
                minDays = person.age.fullYearToDays();
            }
        }
        return minDays;
    }

    public static ArrayList<Person> outputPersonsWithMaxAge(int minDays, ArrayList<Person> people) {
        ArrayList<Person> listOfPersonsWithMaxAge = new ArrayList<>();
        for (Person person : people) {
            if (person.age.fullYearToDays() == minDays) {
                listOfPersonsWithMaxAge.add(person);
            }
        }
        return listOfPersonsWithMaxAge;
    }


    public static Person chooseOneParent(ArrayList<Person> personsOfPersonsWithMaxAge){ //критерий выбора родителя: у кого больше букв имя + фамилия
        HashMap<Integer, Person> personsWithMaxSymbolsQuantityInNames = new HashMap<>();
        for (Person person1 : personsOfPersonsWithMaxAge) {
            personsWithMaxSymbolsQuantityInNames.put(person1.name.firstName.length() + person1.name.lastName.length() - 1, person1);
        }
        int numberOfMaxSymbol = Collections.max(personsWithMaxSymbolsQuantityInNames.keySet());
        return personsWithMaxSymbolsQuantityInNames.get(numberOfMaxSymbol);
    }




    // TODO: 2/3/20 теперь старший это быдет отец, у которого должна быть коллекция всех детишек(все кто младше него). За исключением тех кто того же возраста
    //  они должны дратся несмерть и there can be only one т.е. Падшие воены в список детей не попадают. А каждому ребенку проставляется отец. Создай новый класс
    //  для этого, он будет наследвоать Person и включать новые поля List<Person> children и Person parent.

    // TODO: 2/3/20 или просто создай 10 животных в классе universe. Причем чтобы была как минимум тройная вложенность(хотябы в одном случае) ну и поведение и свойства соответсвующие.


    public static List<Name> createRandomNames() {
        //  TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.
        Name name0 = new Name("Olga ", "Petrova");
        Name name1 = new Name("Victor ", "Nabokov");
        Name name2 = new Name("Semen ", "Ylyich");

        List<Name> names = Arrays.asList(name0, name1, name2);
        return names;
    }

    public static List<Age> createRandomAges() {
        Age age0 = new Age(1995, 06, 12);
        Age age1 = new Age(1994, 05, 11);
        Age age2 = new Age(1993, 04, 10);

        List<Age> ages = Arrays.asList(age0, age1, age2);
        return ages;
    }

    public static void createListOfRandomPersons() {
        ArrayList<Person> randomPersons = new ArrayList();
        Random random = new Random();

        List<Name> names = createRandomNames();
        List<Age> ages = createRandomAges();
        for (int i = 0; i < names.size(); i++) {
            Name name = names.get(random.nextInt(names.size()));
            Age age = ages.get(random.nextInt(ages.size()));

            Person person = new Person(name, age);
            randomPersons.add(person);
        }
        System.out.println("________________________");
        System.out.println("Задача 2:");
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

    private static final int[] DAYS_IN_MONTHS = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int fullYearToDays() {

        int daysInFullYears = countDaysInFullYears();

        int daysInLastYear = countDaysInLastYear();

        return daysInFullYears + daysInLastYear; // суммарный подсчет от 1900 до даты рождения
    }

    private int countDaysInFullYears() {
        int counter1 = 0;
        for (int i = 1900; i <= year; i++) { // подсчет дней за каждый месяц

            boolean isLeapYear = (i % 4 == 0) && (i % 100 != 0 || i % 400 == 0); // учет високосного года

            if (i != year) {
                for (int j = 0; j < DAYS_IN_MONTHS.length; j++) {
                    if (isLeapYear) {
                        DAYS_IN_MONTHS[1] = 29;
                    }
                    counter1 = counter1 + DAYS_IN_MONTHS[j];  // подсчет дней за  год
                }
            }
        }
        return counter1;
    }

    private int countDaysInLastYear() {
        int counter2 = 0;
        boolean isLeapYear = (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0); // учет високосного года

        for (int k = 0; k < month - 1; k++) {
            if (isLeapYear) {
                DAYS_IN_MONTHS[1] = 29;
            }
            counter2 = counter2 + DAYS_IN_MONTHS[k];  // подсчет дней за остаточный месяц
        }
        return counter2 + day;
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