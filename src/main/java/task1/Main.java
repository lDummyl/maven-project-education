package task1;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        first();
        second();

    }

    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
//		Person person1 = new Person("Ben", 24);

        Name name = new Name("Ben");
        Age age = new Age(2010, 11, 5);
        Person person1 = new Person(name, age);
        Person person2 = new Person(new Name("Inna"), new Age(1998, 4, 14));
        Person person3 = new Person(new Name("Grace"), new Age(1993, 2, 9));
        Person person4 = new Person(new Name("Max"), new Age(1993, 2, 1));
        Person person5 = new Person(new Name("Ingrid"), new Age(1993, 4, 14));

        ArrayList<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);

        Person oldest = list.get(0);
        for (Person person : list) {
            System.out.println(person);
            if (person.isOlderThan(oldest)) {
                oldest = person;
            }

        }

        System.out.println("Старший это - " + oldest);
    }

    // TODO: 5/6/20 вот 3 метода с точки зрения логики одинаковые, только 2 параметра переменные, 
    //  как бы это исправить чтобы один метод был при том универсальный? Крохотная подсказка по IDE,
    //  удобней всего выделить строки (52-55) и нажать ctrl+alt+m придумать название общего метода, 
    //  а дубликаты идея найдет и заменит сама. Тогда будет 4 метода, но все разные и без копипасты.
    
    public static int randomYear ()
    {
        int min = 1920;
        int max = 2010;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff);
        return i + min;
    }
    public static int randomMonth ()
    {
        int min = 1;
        int max = 12;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff);
        return i + min;
    }
    public static int randomDay ()
    {
        int min = 1;
        int max = 30;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff);
        return i+ min;
    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

        // TODO: 5/6/20 вообще я имел в виду скорей коллекцию имен, строковых. Фамилии к слову можно сделать из тех же имен Lastname = Firstname + "son"
        //  так получиться намного больше вариантов/комбинаций уникальных. Сейчас у тебя создается обычно 3-4 человека в итоге. А нужно стабильно 5.
        ArrayList<Name> listOfNames = new ArrayList<>();
        listOfNames.add(new Name("Ella", "Brown"));
        listOfNames.add(new Name("Kate", "Stevenson"));
        listOfNames.add(new Name("Mike", "Berry"));
        listOfNames.add(new Name("Harry", "Kane"));
        listOfNames.add(new Name("Kevin", "Smith"));
        HashMap<Name, Age> persons = new HashMap<>(listOfNames.size()); // TODO: 5/6/20 задавать размер коллекции лишнее, там нормальные механизмы расширения 


        // TODO: 5/6/20 круто, с точки зрения практики можно, но обычный for в данном случае существенно проще его шаблон можно вызвать командой itar.
        int i = 0;
        do {
            Random random = new Random();
            persons.put(listOfNames.get(random.nextInt(listOfNames.size())), new Age (randomYear(), randomMonth(), randomDay()));
            i++;
        }
        while (i<listOfNames.size());

        for (Map.Entry<Name, Age> nameAgeEntry : persons.entrySet()) {
            System.out.println(nameAgeEntry);
        }

        // TODO: 5/6/20 в заключении не будет большого страха если ты переиспользуешь кусок кода который из листа кандидатов выбирал нужного,
        //  только лучше обойтись без копирования а вынести это в отдельную функцию.

    }

}

class Name {

    String firstName;
    String lastName;

    public Name(String name) {
        firstName = name;
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
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
        return "Age{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

class Person {
    public Person(Name name, Age age) {
        this.name = name;
        this.age = age;
    }

    Name name;
    Age age;

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    public boolean isOlderThan(Person oldest) {
//		oldest 1900 this 1990
        return oldest.age.year > age.year || oldest.age.month >= age.month || oldest.age.day >= age.day;
    }
}