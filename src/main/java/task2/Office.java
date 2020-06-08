package task2;

import task1.Age;
import task1.Name;
import task1.PersonProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Office {
	Director director;
	Hr hr;
	Secretary secretary;

	public Office() {
	}

	public Office(Director director, Hr hr) {
		this.director = director;
		this.hr = hr;
	}

	public void select (Director director, Hr hr, List <Secretary> list)
	{
		hr.passInterview(list);
		while (!director.checkList(list))
		{
			list = hr.passInterview(list);
		}
		if (director.checkList(list))
		{
			Random random = new Random();
			secretary = list.get(random.nextInt(list.size()));
		}
		invitePeople(secretary);
	}

	void invitePeople (Object human){

	}

	public static void main(String[] args) {
		Director steveJobs = new Director(new Name("Steve", "Jobs"), new Age(1955, 1, 24));
		Director sergeyBrin = new Director(new Name("Sergey", "Brin"), new Age(1973, 7, 21));
		Hr oscar = new Hr(new Name("Oscar"), new Age(LocalDate.of(1994, 4, 15)));
		Office apple = new Office(steveJobs, oscar);
		Office google = new Office();
		PersonProvider personProvider = new PersonProvider();
		List<Secretary> secretaries = personProvider.getSecretaries(100);
		apple.select(steveJobs, oscar, secretaries);
		List <Object> officeWorkers = new ArrayList<>();
		officeWorkers.add(apple.director);
		officeWorkers.add(apple.hr);
		officeWorkers.add(apple.secretary);



		for (Object worker : officeWorkers) {
			System.out.println(worker);
		}
		// TODO: 6/4/20 А в офисе никого? все вопросы смотрю тут решаются, трендово конешно, но не по условию





		//System.out.println(apple.secretary != null);


		//претенденты идут по одному, когда их достаточно,
		// то диретор принимает решение и берет одного в штат

	}
}

