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


	// TODO: 6/11/20 сделай  main макс в 10 строк и каждый метод макс в 10 строк
	public static void main(String[] args) throws Exception {
		PersonProvider personProvider = new PersonProvider();
		Office office = new BusinessCenter().createOffice();
		List<Secretary> secretaries = personProvider.getSomeOf(Secretary.class, 1000);
		List<Security> securities = personProvider.getSomeOf(Security.class, 1000);
		List<Jurist> jurists = personProvider.getSomeOf(Jurist.class, 1000);
		List<Accountant> accountants = personProvider.getSomeOf(Accountant.class, 1000);

		office.director.invite(office, office.hr.filter(secretaries), office.hr.filter(securities), office.hr.filter(jurists));
		office.director.invite(office, office.hr.filter(accountants), 2);

		office.listWorkers();



	}
}
