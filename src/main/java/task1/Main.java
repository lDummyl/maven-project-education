package task1;


import java.util.*;

public class Main {

	public static void main(String[] args) {
		first();
	//	second();

	}

	public static void first(){
		// TODO: 1/26/20 ПЕРВЫЙ ЭТАП создать 5 разных человек и вывести имя старшего

		Age age0 = new Age(2010,01,10);
		Name name0 = new Name("Olga ", "Petrova");
		Person person0 = new Person(name0, age0);

		Age age1 = new Age(1956,01,10);
		Name name1 = new Name("Victor ", "Nabokov");
		Person person1 = new Person(name1, age1);

		Age age2 = new Age(1956,01,10);
		Name name2 = new Name("Semen ", "Ylyich");
		Person person2 = new Person(name2, age2);

		Age age3 = new Age(1995,03,9);
		Name name3 = new Name("Anna ", "Ivanova");
		Person person3 = new Person(name3, age3);

		Age age4 = new Age(1984,01,10);
		Name name4 = new Name("Maria", "Torova");
		Person person4 = new Person(name4, age4);

		HashMap<Age, Name> persons1 = new HashMap<Age, Name>(){{ put(age0, name0);
			put(age1, name1);
			put(age2, name2);
			put(age3, name3);
			put(age4, name4);
		}};
		HashMap<Name, Integer> personWinners = new HashMap<>();


		int daysResult = 0;
		int minDays = 10000000;
		ArrayList<Name> winners = new ArrayList<>();

			for (Age age : persons1.keySet()) {


				int[] daysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
				int counter1 = 0;
				int counter2 = 0;

				    for (int i = 1900; i <= age.year ; i++) { // подсчет дней за каждый месяц

						boolean isLeapYear = (i % 4 == 0) && (i % 100 != 0 || i % 400 == 0); // учет високосного года

						if(i != age.year) {
							for (int j = 0; j < daysInMonths.length; j++) {
								if (isLeapYear) {
									daysInMonths[1] = 29;
								}
								counter1 = counter1 + daysInMonths[j];  // подсчет дней за  год
							}
						}

						if (i == age.year) {
							for (int k = 0; k < age.month; k++){
								if (isLeapYear) {
									daysInMonths[1] = 29;
								}
								counter2 = counter2 + daysInMonths[k];  // подсчет дней за остаточный месяц
							}
						}
						daysResult = counter1 + counter2 + age.day; // суммарный подсчет от 1900 до даты рождения


				    }
				if (daysResult < minDays){ // находим минимальное кол-во дней
					minDays = daysResult;
				}
				System.out.println("Количество дней с 1900 года: " + daysResult + "   Имя человека: " + persons1.get(age));
				personWinners.put(persons1.get(age), daysResult);

			}

		for (Map.Entry<Name, Integer> entry : personWinners.entrySet()) { // если неск человек с одинаковой датой рождения
			if (entry.getValue() == minDays){
				winners.add(entry.getKey());
			}
		}

		System.out.println("");
		System.out.println("Наименьшее кол-во дней2 : " + minDays + "    Наибольший возраст: " + winners);
		System.out.println("");


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