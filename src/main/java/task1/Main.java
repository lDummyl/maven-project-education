package task1;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        first();
        second();
    }

    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
        List<Person> listPersons = new ArrayList<Person>();
        Person person = new Person(new Name("Vasily", "S"), new Age(1989, 11, 11));
        Person person2 = new Person(new Name("Ivan", "K"), new Age(2010, 11, 5));
        Person person3 = new Person(new Name("Sergey", "M"), new Age(1980, 9, 2));
        Person person4 = new Person(new Name("Nina", "I"), new Age(1984, 3, 5));
        Person person5 = new Person(new Name("Masha", "O"), new Age(1990, 6, 7));
        listPersons.add(person);
        listPersons.add(person2);
        listPersons.add(person3);
        listPersons.add(person4);
        listPersons.add(person5);

        LocalDate date = LocalDate.now();
        int number = 0;
        for (int i = 0; i < listPersons.size(); i++) {
            LocalDate localDateComparable = LocalDate.of(listPersons.get(i).age.year, listPersons.get(i).age.month, listPersons.get(i).age.day);
            if (date.isBefore(localDateComparable)) {
                date = date;
            } else {
                date = localDateComparable;
                number = i;
            }
        }
        System.out.println(listPersons.get(number).name);
        System.out.println();
    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.
        List listAges = new ArrayList<Age>();
        listAges.add(new Age(2010, 11, 5));
        listAges.add(new Age(1989, 5, 11));
        listAges.add(new Age(1980, 9, 2));
        listAges.add(new Age(1984, 3, 5));
        listAges.add(new Age(1990, 6, 7));
        listAges.add(new Age(1999, 7, 1));
        listAges.add(new Age(2002, 8, 2));
        listAges.add(new Age(2000, 1, 17));

        List listNames = new ArrayList<Name>();
        listNames.add(new Name("Nina", "I"));
        listNames.add(new Name("Masha", "O"));
        listNames.add(new Name("Sergey", "M"));
        listNames.add(new Name("Ivan", "K"));
        listNames.add(new Name("Vasily", "S"));
        listNames.add(new Name("Ruslan", "Z"));
        listNames.add(new Name("Irina", "P"));
        listNames.add(new Name("Tanya", "E"));

        // LIST
//        List list = new ArrayList<Person>();
//        while (1==1){
//            list.add(new Person(listNames.get(new Random().nextInt(7)), listAges.get(new Random().nextInt(7))));
//            if (list.size()==5){
//                break;
//            }
//        }
//
//        for (Object o:list
//             ) {
//            System.out.println(o);
//        }

        // SET
//        Set set = new HashSet<Person>();
//        while (1==1){
//            set.add(new Person(listNames.get(new Random().nextInt(7)), listAges.get(new Random().nextInt(7))));
//            if (set.size()==5){
//                break;
//            }
//        }
//        for (Object o:set
//             ) {
//            System.out.println(o);
//        }

        // MAP
        Map map = new HashMap();
        while (1 == 1) {
            map.put(listNames.get(new Random().nextInt(7)), listAges.get(new Random().nextInt(7)));
            if (map.size() == listNames.size()) {
                break;
            }
        }

        for (Object o : map.entrySet()
        ) {
            System.out.println(o);
        }
    }

}

class Name {

    String firstName;
    String lastName;

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'';
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class Age {

    int year;
    int month;
    int day;


    public Age(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

}

class Person {

    Name name;
    Age age;

    public Person(Object name, Object age) {
        this.name = (Name) name;
        this.age = (Age) age;
    }

    @Override
    public String toString() {
        return "firstName='" + name.firstName + '\'' +
                ", lastName='" + name.lastName + '\'' +
                ", age=" + age.year + " " + age.month + " " + age.day + '\'';
    }

}