package task1;


import java.util.*;

public class Main {

	public static void main(String[] args) {
		first();
		second();

	}

	public static void first(){
		// TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего

		Age age0 = new Age(1995,06,12);
		Name name0 = new Name("Olga ", "Petrova");
		Person person0 = new Person(name0, age0);

		Age age1 = new Age(1994,05,11);
		Name name1 = new Name("Victor ", "Nabokov");
		Person person1 = new Person(name1, age1);

		Age age2 = new Age(1993,04,10);
		Name name2 = new Name("Semen ", "Ylyich");
		Person person2 = new Person(name2, age2);

		Age age3 = new Age(1991,03,9);
		Name name3 = new Name("Anna ", "Ivanova");
		Person person3 = new Person(name3, age3);

		Age age4 = new Age(1991,02,8);
		Name name4 = new Name("Maria", "Torova");
		Person person4 = new Person(name4, age4);

		Map<Age, Name> persons = new HashMap<Age, Name>() {{
			put(age0, name0);
			put(age1, name1);
			put(age2, name2);
			put(age3, name3);
			put(age4, name4);
		}};

		Map<Age, Name> yearWinners = new HashMap<>();
		Map<Age, Name> monthWinners = new HashMap<>();
		Map<Age, Name> dayWinners = new HashMap<>();
		int minYear =  2020;
		int minMonth = 12;
		int minDay = 31;


		for (Age age : persons.keySet()) {
			if(age.year < minYear){
				minYear = age.year;
			}
		}
		// TODO: 1/27/20 теперь тебе осталось только проработать месяцы и дни.
		for (Map.Entry<Age, Name> entry : persons.entrySet()) {
			if(entry.getKey().year == minYear){
				yearWinners.put(entry.getKey(), entry.getValue());  // нашли одногодок с наибольшим возрастом
			}
		}
		System.out.println("Наибольший возраст у человека / Родились в один год: " + yearWinners);

		if (yearWinners.size() > 1) { // если не менее 2 человек с одинаковым годом рождения
			for (Age age : yearWinners.keySet()) {
				if (age.month < minMonth) {
					minMonth = age.month;   // находим чувака с наименьшим месяцем рождения. Т.е. он старший
				}
			}
			for (Map.Entry<Age, Name> entry1 : yearWinners.entrySet()) {
				if (entry1.getKey().month == minMonth) {
					monthWinners.put(entry1.getKey(), entry1.getValue());  // на случай, если одногодки родились в одном месяце
				}
				else {

				}
			}

			if (monthWinners.size() > 1){     // если не менее 2 человек с одинаковым месяцем рождения
				for (Age age : monthWinners.keySet()) {
					if (age.day < minDay) {
						minDay = age.day;     // находим дату рождения старшего чувака.
					}
				}
				for(Map.Entry<Age, Name> entry2 : monthWinners.entrySet()){
					if (entry2.getKey().day == minDay) {
						dayWinners.put(entry2.getKey(), entry2.getValue());  // если родились  однim числоm
						System.out.println("День Рождения в один день: " + dayWinners);
					}
					else {

					}
				}
			}
		}

		System.out.println(person0.age);
	}

	public static void second(){
		// TODO: 1/26/20 ВТОРОЙ ЭТАП создать коллекцию имен и создавать людей в цикле, подставляя имена и возраст рандомно.
		Name name0 = new Name("Olga ", "Petrova");
		Name name1 = new Name("Victor ", "Nabokov");
		Name name2 = new Name("Semen ", "Ylyich");

		Age age0 = new Age(1995,06,12);
		Age age1 = new Age(1994,05,11);
		Age age2 = new Age(1993,04,10);

		List<Name> names = Arrays.asList(name0, name1, name2);
		List<Age> ages = Arrays.asList(age0,age1,age2);
		ArrayList<Person> randomPersons = new ArrayList();

		Random random = new Random();

		for (int i = 0 ; i < names.size() ; i++) {
			Name name = names.get(random.nextInt(names.size()));
			Age age = ages.get(random.nextInt(ages.size()));

			Person person = new Person(name, age);
			randomPersons.add(person);

		}
		System.out.println(randomPersons);
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

	Name(String firstName, String lastName){
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

	Age(int year, int month, int day){
		this.day = day;
		this.month = month;
		this.year = year;
	}

}

class Person {

	Name name;
	Age age;

	Person(Name name, Age age){
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