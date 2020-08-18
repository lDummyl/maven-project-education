package task2;

import task1.Age;
import task1.Name;
import task1.PersonProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Office {
	final Director director;
	final Hr hr;
	Secretary secretary;

	public Office(Director director, Hr hr) {
		this.director = director;
		this.hr = hr;
	}

	// TODO: 6/8/20 добавлю условие: класс Office неизвеняемый, ему можно добавлять только приватные методы,
	//  ни новых публичных ни новых конструкторов ни добвалять и не модифицировать контракты существующих.
	//  Так же он не должен содержать main метода.

	void invitePeople(Object human) {
	}

	Director steveJobs = new Director(new Name("Steve", "Jobs"), new Age(1955, 1, 24));
	Director sergeyBrin = new Director(new Name("Sergey", "Brin"), new Age(1973, 7, 21));
	Hr oscar = new Hr(new Name("Oscar"), new Age(LocalDate.of(1994, 4, 15)));
	Hr mark = new Hr(new Name("Mark", "Grey"), new Age(1990, 5, 11));
	Office apple = new Office(steveJobs, oscar);
	Office google = new Office(sergeyBrin, mark);
	PersonProvider personProvider = new PersonProvider();
	List<Secretary> secretaries = personProvider.getSecretaries(100);
	Secretary appleSecretary = apple.director.select(apple, apple.hr, secretaries);

	/*private void printListOfOfficeWorkers (Office office)
	{
		ArrayList<Object> workers = new ArrayList<>();
		workers.add(office.director);
		workers.add(office.hr);
		workers.add(office.secretary);
		for (Object worker : workers) {
			System.out.println(worker);
		}
	}

	 */
}

		//претенденты идут по одному, когда их достаточно,
		// то диретор принимает решение и берет одного в штат


