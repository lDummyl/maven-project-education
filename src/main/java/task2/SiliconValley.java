package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import task1.PersonProvider;

import java.util.ArrayList;
import java.util.List;

public class SiliconValley {
	public static void main(String[] args) {
		Office apple = new Office();
		Office google = new Office();
		Director steveJobs = new Director("Steve Jobs" );
		apple.director = steveJobs;
		Director sergeyBrin = new Director("Sergey Brin");
		google.director = sergeyBrin;

		Hr oscar = new Hr("Oscar");
		apple.hr = oscar;
		PersonProvider personProvider = new PersonProvider();
		List<Secretary> secretaries = personProvider.getSecretaries(100);

		for (Secretary secretary : secretaries) {
			apple.invitePeople(secretary);
		}

		System.out.println(apple.secretary != null);



	}
}
