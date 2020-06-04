package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import task1.Age;
import task1.Name;
import task1.PersonProvider;

import java.time.LocalDate;
import java.util.List;

public class SiliconValley {
	public static void main(String[] args) {
		Office apple = new Office();
		Office google = new Office();
		Director steveJobs = new Director(new Name("Steve", "Jobs"), new Age(1955,1,24) );
		apple.director = steveJobs;
		Director sergeyBrin = new Director(new Name("Sergey", "Brin"), new Age(1973, 7, 21));
		google.director = sergeyBrin;

		Hr oscar = new Hr(new Name("Oscar"), new Age(LocalDate.of(1994, 4, 15)));
		apple.hr = oscar;
		PersonProvider personProvider = new PersonProvider();
		List<Secretary> secretaries = personProvider.getSecretaries(100);

		for (Secretary secretary : secretaries) {
			apple.invitePeople(secretary);
			//System.out.println(secretary);
			//secretary.interview(secretary);

		}
		// TODO: 6/4/20 А в офисе никого? все вопросы смотрю тут решаются, трендово конешно, но не по условию
		System.out.println(Hr.passInterview(secretaries).size());
		//System.out.println(oscar.passInterview(secretaries));
		System.out.println(steveJobs.select(Hr.passInterview(secretaries)));


		//System.out.println(apple.secretary != null);

	}
}
