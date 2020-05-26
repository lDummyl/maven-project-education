package task1;

import task2.Secretary;

import java.util.*;

public class PersonProvider {


    public  List<Person> getPeople() {
        List<String> listOfFirstNames = Arrays.asList("Ella", "Harry", "Artur", "Kevin", "Kate");
        List<String> listOFLastNames = Arrays.asList("Brown", "Harrison", "Stevenson", "Gibson", "Smith");

        Map<Name, Age> persons = new HashMap<>(); // TODO: 5/6/20 задавать размер коллекции лишнее, там нормальные механизмы расширения

        // TODO: 5/6/20 круто, с точки зрения практики можно, но обычный for в данном случае существенно проще его шаблон можно вызвать командой itar.

        // переделала коллекцию - добавила рандомный выбор фамилий
        for (int i = 0; i < listOfFirstNames.size(); i++) {
            Random random = new Random();
            Name name = new Name(listOfFirstNames.get(random.nextInt(listOfFirstNames.size())), listOFLastNames.get(random.nextInt(listOFLastNames.size())));
            Age age = new Age(randomYear(), randomMonth(), randomDay());
            persons.put(name, age);
        }
        List<Person> people = new ArrayList<>();
        for (Map.Entry<Name, Age> nameAgeEntry : persons.entrySet()) {
            people.add(new Person(nameAgeEntry.getKey(), nameAgeEntry.getValue()));
            System.out.println(nameAgeEntry);
        }
        return people;
    }
    public static int randomYear() {
        int min = 1980;
        int max = 2010;
        return randomDate(min, max);
    }

    public static int randomDate(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff);
        return i + min;
    }

    public static int randomMonth() {
        int min = 1;
        int max = 12;
        return randomDate(min, max);
    }

    public static int randomDay() {
        int min = 1;
        int max = 30;
        return randomDate(min, max);
    }


    public List<Secretary> getSecretaries(int i) {
        return null;
    }
}
