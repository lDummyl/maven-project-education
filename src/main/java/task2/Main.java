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


    public static void main(String[] args) {
    	PersonProvider personProvider = new PersonProvider();
    	BusinessCenter sova = new BusinessCenter();
		Office sovaOffice1 = sova.createOffice(1, 1, 1, 3);
		Office sovaOffice2 = sova.createOffice(1, 1, 1, 2);

		// TODO: 5/26/20 как думашь стоит уже убрать копипасту, или может создать бизнес центр?
		List<Secretary> secretaries = personProvider.getSomeSecretaries(1000);
		List<Security> securities = personProvider.getSomeSecurities(1000);
		List<Jurist> jurists = personProvider.getSomeJurists(1000);
		List<Accountant> accountants = personProvider.getSomeAccountants(1000);

	    // TODO: 5/31/20 6 аргуменотв многовато бывают, офисы где должностей побольше, что будешь делать?
	    //  и потом почему 3 раза бухгалтера? а понял, жесть? Как насчет завсети поле в офисе requiredQtyOfAccountants и инициализировать его при создании объекта офис
	    //  и потом все было нормально, создание офиса нужно было просто вывести в отдельный метод и все(офиса а не офисов!)

		/*
		Хорошо, вот 2 способа заполнения офисов (методы используются одинаковые). В одном случае я могу
		использовать сколько угодно аргументов, в другом сколько угодно строчек метода с одним аргументом.
		Как правильно?
		 */

		try {
			sovaOffice1.work(secretaries, securities, jurists, accountants);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sovaOffice1.listWorkers();

		try{
			sovaOffice2.work(secretaries);
			sovaOffice2.work(securities);
			sovaOffice2.work(jurists);
			sovaOffice2.work(accountants);
		} catch (Exception e){
			e.printStackTrace();
		}
		sovaOffice2.listWorkers();


		// TODO: 5/31/20 да и 5 тоже



		// TODO: 5/26/20 какие-то они у тебя бездушные, давай один директор будет добрый а другой капризный, только не на совах а на деле.


    }
}
