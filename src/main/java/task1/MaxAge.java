package task1;

import java.util.*;

public class MaxAge {
    public static void main(String[] args) {
        //Task1:
        ArrayList<Person2> people = createPersons();
        outputGeneralListWithNamesAndNumbersOfDaysFrom1900(people);
        findMaxAge(people);
        int minDays = findMaxAge(people);
        ArrayList<Person2> peopleWithMaxAge = outputPersonsWithMaxAge(minDays, people);
        System.out.println("Наибольший возраст: " + peopleWithMaxAge);
        System.out.println(chooseOneParent(outputPersonsWithMaxAge(minDays, people)));

        //Task2:
        createListOfRandomPersons();
    }

    //TODO Task1:
    //создадим объекты Person и засунем их в список people:
    public static ArrayList<Person2> createPersons(){
        ArrayList<Person2> people = new ArrayList<Person2>();

        for (int i = 0; i < 5; i++) {
            Person2 person2 = new Person2(getRandomName(), getRandomAge());
            people.add(person2);
        }
        return people;
    }

    //найдем кол-во дней от 1900 для каждого в списке people:
    public static void outputGeneralListWithNamesAndNumbersOfDaysFrom1900(ArrayList<Person2> people){
        for (Person2 peopleCounter : people) {
            System.out.println("Количество дней от 1900: " + peopleCounter.year.getDaysFrom1900() + "       Имя: " + peopleCounter.name);
        }
    }

    //находим людей макс возраста из списка:
    public static int findMaxAge(ArrayList<Person2> people){
        int minDays = 1000000;

        for (Person2 person : people) {
            if (person.year.getDaysFrom1900() < minDays) { // находим минимальное кол-во дней
                minDays = person.year.getDaysFrom1900();
            }
        }
        return minDays;
    }

    // выводим людей с макс возрастом:
    public static ArrayList<Person2> outputPersonsWithMaxAge(int minDays, ArrayList<Person2> people){
        ArrayList<Person2> listOfPersonsWithMaxAge = new ArrayList<>();
        for (Person2 person : people) {
            if (person.year.getDaysFrom1900() == minDays) {
                listOfPersonsWithMaxAge.add(person);
            }
        }
        return listOfPersonsWithMaxAge;}

    //выбираем одного с макс возрастом по принципу, у кого больше букв:
    public static Person2 chooseOneParent(ArrayList<Person2> listOfPersonsWithMaxAge){
        HashMap<Integer, Person2> personsWithMaxSymbolsQuantityInNames = new HashMap<>();
        for (Person2 persons : listOfPersonsWithMaxAge) {
            personsWithMaxSymbolsQuantityInNames.put(persons.name.name.length(), persons); //????????????????????
        }
        int numberOfMaxSymbol = Collections.max(personsWithMaxSymbolsQuantityInNames.keySet());
        return personsWithMaxSymbolsQuantityInNames.get(numberOfMaxSymbol);
    }

    //TODO Task2:
    static List<String> randomNames = Arrays.asList("Misha", "Sveta", "Olga");

    //создадим список имен
    public static Name2 getRandomName(){
        String randName = randomNames.get(rand.nextInt(randomNames.size()));
        return new Name2(randName);
    }

    static Random rand = new Random();

    // создадим список возрастов
    public static Age2 getRandomAge() {
        int randomAge = 1900 + rand.nextInt(120);
        Age2 age2 = new Age2(randomAge);
        return age2;
    }

    // создадим список людей с рандомными именами и возрастами.
    public static void createListOfRandomPersons(){}

    }

class Person2{
    Name2 name;
    Age2 year;

    Person2(Name2 name, Age2 year) {
        this.name = name;
        this.year = year;
    }


    @Override
    public String toString() {
        return "Person:" + name + year + "|";
    }
}

class Age2{
    int year;

    Age2(int year){
      this.year = year;
    }

    private static final int[] DAYS_IN_MONTHS = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int getDaysFrom1900(){
        int counter1 = 0;
        for (int i = 1900; i <= year; i++) { // подсчет дней за каждый месяц
                for (int j = 0; j < DAYS_IN_MONTHS.length; j++) {
                    counter1 = counter1 + DAYS_IN_MONTHS[j];  // подсчет дней за  год
            }
        }
        return counter1;
    }

    @Override
    public String toString() {
        return "Age: " + year + "|";
    }
}

class Name2{
    String name;
    Name2(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "Name: " + name + "|";
    }

}