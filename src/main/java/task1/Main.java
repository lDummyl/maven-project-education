package task1;

import java.time.LocalDate;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        //first();
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
        Person oldest = getOldest(list);

        System.out.println("Старший это - " + oldest);
    }
//    public static Person getOldest(List<Person> people){ contract
//    public static Person return type
//    getOldest(List<Person> people){ signature of method

    public static Person getOldest(List<Person> people) {

        Person oldest = people.get(0);
        for (Person person : people) {
            System.out.println(person);
            if (person.isOlderThan(oldest)) {
                oldest = person;
            }
        }
        return oldest;
    }

    // TODO: 5/6/20 вот 3 метода с точки зрения логики одинаковые, только 2 параметра переменные, 
    //  как бы это исправить чтобы один метод был при том универсальный? Крохотная подсказка по IDE,
    //  удобней всего выделить строки (52-55) и нажать ctrl+alt+m придумать название общего метода, 
    //  а дубликаты идея найдет и заменит сама. Тогда будет 4 метода, но все разные и без копипасты.



    // TODO: 5/18/20 можно использовать контракт проще. Можно так же использовать всмето Date класс LocalDate. Его проще получить сравнивать и прочее
   /* public static Date toDate (Age age)
    {
        Calendar calendar = new GregorianCalendar();
//        ....
        return calendar.getTime();
    }
    */

    public LocalDate toDate(Age age) {
        return LocalDate.of(age.year, age.month, age.day);
    }

    // TODO: 5/20/20 так не просто можно а оптимально, за исключением того что мы изучаем ООП а в нем статик ругательное слово, сделай больше похожим на equals метод можно модифицировать isOlderThan
    // можно так? или нужно высчитывать количество прожитых дней и сравнивать их?
    public boolean isOlder(LocalDate date, LocalDate date2) {
        return date2.isBefore(date);
    }

    // return (int)( (date.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24)); // TODO: 5/18/20 вот тут можно почитать что не так http://www.8bytes.net/2018/04/18/antipattern-1-magicheskoe-chislo/

    public Person getOldestPerson(List<Person> people) {
        Person oldest = people.get(0);
        LocalDate date = toDate(oldest.age);
        for (Person person : people) {
            if (isOlder(date, toDate(person.age))) {
                date = toDate(person.age);
                oldest = person;
            }
        }
        return oldest;
    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.

        // TODO: 5/6/20 вообще я имел в виду скорей коллекцию имен, строковых. Фамилии к слову можно сделать из тех же имен Lastname = Firstname + "son"
        //  так получиться намного больше вариантов/комбинаций уникальных. Сейчас у тебя создается обычно 3-4 человека в итоге. А нужно стабильно 5.
        PersonProvider personProvider = new PersonProvider();
        List<Person> people = personProvider.getPeople();
        Main main = new Main();

        // Person oldest = getOldest(people);
        Person oldest = main.getOldestPerson(people);
        System.out.println("Старший это - " + oldest);
    }


    // TODO: 5/6/20 в заключении не будет большого страха если ты переиспользуешь кусок кода который из листа кандидатов выбирал нужного,
    //  только лучше обойтись без копирования а вынести это в отдельную функцию.

}
