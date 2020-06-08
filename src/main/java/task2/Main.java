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
		Office sovaOffice1 = sova.createOffice(3);
		// TODO: 6/8/20 ну а он что простаивает?
		Office sovaOffice2 = sova.createOffice(2);

		List<Secretary> secretaries = personProvider.getSomeOf(Secretary.class, 1000);
		List<Security> securities = personProvider.getSomeOf(Security.class, 1000);
		List<Jurist> jurists = personProvider.getSomeOf(Jurist.class, 1000);
		List<Accountant> accountants = personProvider.getSomeOf(Accountant.class, 1000);

		sovaOffice1.setSecretaries(secretaries, 1);
		sovaOffice1.setSecurities(securities, 1);
		sovaOffice1.setJurists(jurists, 1);
		sovaOffice1.setAccountants(accountants, 3);

		sovaOffice1.listWorkers();


		// Только не бей меня сильно за эту копипасту. Я не придумал, как вызывать сеттеры в офисе
		// без использования логики. Я хотел написать один универсальный метод, в который я передаю
		// лист кандидатов, а дальше директор и хр делают свое дело по отбору кандидатов.
		// Основная проблема в том, что директор не знает о методах офиса и даже если он может понимать,
		// лист каких кандидатов ему пришел, то он не может вызвать соответствующий сеттер на офисе.

		// TODO: 6/8/20  А кто мешает директору передать ссылку на офис в котором он работает в качестве поля?

		// Поэтому я написал каждый сеттер отдельно. Теперь методы отбора не зависят от офиса, но появилась кописаста.



	}
}
