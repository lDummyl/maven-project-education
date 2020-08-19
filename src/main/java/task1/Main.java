package task1;


import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        // TODO: 7/15/20 hi from outside
        first();
        second();

    }


    public static void first() {
        // TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего
        ArrayList<Person> people = new ArrayList<>();


        Person ivanPetrov = new Person("Иван Петров", 13, 8, 1956);
        people.add(ivanPetrov);
        people.add(new Person("Иван Иванов", 12, 5, 1985));
        people.add(new Person("Иван Иванов", 12, 5, 1915));


        System.out.println(findOldestPerson(people));


    }

    public static void second() {
        // TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.
		ArrayList<Person> peoples = new ArrayList<>();
		int count = 100;
        while (count > 0) {
            peoples.add(new Person(new Name(), new BirthDate()));
            count--;
        }

        Person olderPerson = findOldestPerson(peoples);
        for (Person people : peoples) {
            System.out.println(people);
        }
        System.out.println("===========");
		System.out.println(olderPerson);

    }

    public static Person findOldestPerson (List<Person> persons) {
    	Person oldestPerson = persons.get(0);
		for (Person person : persons) {
			boolean answer = oldestPerson.isOlderThan(person);
			if (!answer) {
				oldestPerson = person;
			}
		}
    	return oldestPerson;
	}

}

