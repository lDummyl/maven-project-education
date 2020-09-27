package homeworkTask2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonProvider {
    List<String> listOfFirstNames = Arrays.asList("Artur", "Kate", "Max", "Kevin", "Mike", "Oscar", "Lucy", "Garrett", "Steve", "Grace");
    List<String> listOfLastNames = Arrays.asList("Grey", "Black", "Brown", "Jackson", "Stevenson", "Gibson", "Tyson", "Jameson", "Miller", "Jones");

    public int difference(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        return min + random.nextInt(diff);
    }

    public Age getBirthDate() {
        int year = difference(1960, 2000);
        int month = difference(1, 12);
        int day;
        switch (month) {
            case 1:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    day = difference(1, 29);
                } else {
                    day = difference(1, 28);
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = difference(1, 30);
                break;
            default:
                day = difference(1, 31);
                break;
        }
        return new Age(day, month, year);
    }

    public Person getPerson() {
        Random random = new Random();
        String firstName = listOfFirstNames.get(random.nextInt(listOfFirstNames.size()));
        String lastName = listOfLastNames.get(random.nextInt(listOfLastNames.size()));
        Name name = new Name(firstName, lastName);
        Age age = getBirthDate();
        return new Person(name, age);
    }

    // можно ли сделать общий метод по созданию списков объектов для классов-наследников Person?
    // или преобразовать один тип элементов в другой?
    // TODO: 9/16/20 да можно посмотри в ветке safronovs, это немного сложновато, можно попробовать не так лаконично, но проще.

    ArrayList<Person> people = new ArrayList<>();

    public List getPeople(int x) {
        for (int i = 0; i < x; i++) {
            people.add(getPerson());
        }
        return people;
    }

    public <T extends Person> List<T> getSomePeople(Class<T> clazz, int x) throws Exception {
        List<Person> personList = new PersonProvider().getPeople(x);
        List<T> list = new ArrayList<>();
        for (Person person : personList) {
            Constructor<T> constructor = clazz.getConstructor(Person.class);
            T t = constructor.newInstance(person);
            list.add(t);
        }
        return list;
    }
    //67 -дженерик используется, чтобы не было необходимости явного приведения типов. extends Person - указан, чтобы метод принимал
    //на вход только Person и его наследников
    //в параметрах указаны класс, к которому необходимо привести тип на выходе и кол-во обьектов, кот. попадут в список
    //68 - создание списка обьектов Person
    //69 - создание нового список необходимого типа
    //71 - вызов конструктора класса person
    //72 - возвращает объект, приведенный к типу указанного класса

    public <T extends Person> List getWorkers(Class<T> tClass, int x) {
        if (tClass.equals(Secretary.class)) {
            List<Secretary> secretaries = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                secretaries.add(new Secretary(getPerson()));
            }
            return secretaries;
        }
          else if (tClass.equals(Accountant.class)) {
            List <Accountant> accountants = new ArrayList<>();
            for (int i=0; i<x; i++) {
                accountants.add(new Accountant(getPerson()));
            }
            return accountants;
        }
          else if (tClass.equals(Jurist.class))
        {
            List <Jurist> jurists = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                jurists.add(new Jurist(getPerson()));
            }
            return jurists;
        }
        return null;
    }
}




