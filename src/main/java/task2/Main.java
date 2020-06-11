package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import task1.Person;
import task1.PersonProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {


	public static void main(String[] args) throws Exception {
		PersonProvider personProvider = new PersonProvider();
		BusinessCenter sova = new BusinessCenter();

		Director director1 = personProvider.getSomeDirector();
		Director director2 = personProvider.getSomeDirector();
		Hr hr1 = personProvider.getSomeHr();
		Hr hr2 = personProvider.getSomeHr();

		Office sovaOffice1 = sova.createOffice(director1, hr1);
		Office sovaOffice2 = sova.createOffice(director2, hr2);

		List<Secretary> secretaries = personProvider.getSomeOf(Secretary.class, 1000);
		List<Security> securities = personProvider.getSomeOf(Security.class, 1000);
		List<Jurist> jurists = personProvider.getSomeOf(Jurist.class, 1000);
		List<Accountant> accountants = personProvider.getSomeOf(Accountant.class, 1000);

		sovaOffice1.director.invite(sovaOffice1, hr1.filter(secretaries), hr1.filter(securities), hr1.filter(jurists));
		sovaOffice1.director.invite(sovaOffice1, sovaOffice1.hr.filter(accountants), 2);
		sovaOffice2.director.invite(sovaOffice2, hr2.filter(secretaries), hr2.filter(securities), hr2.filter(jurists));
		sovaOffice2.director.invite(sovaOffice2, sovaOffice1.hr.filter(accountants), 3);

		sovaOffice1.listWorkers();
		sovaOffice2.listWorkers();

		/*
		Пода дошел до этого. Метод интервью у Hr использую вместе с отсевом по дате рождения.
		Мне здесь не нравится то, что я могу директору в качестве первого аргумента передать не тот офис, в котором он руководит,
		и директор назначит там своих сотрудников. Как ограничить использование сеттера одним объектом?
		 */



	}
}
