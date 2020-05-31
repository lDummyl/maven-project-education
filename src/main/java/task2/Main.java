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
		List<Office> sovaOffice = sova.createOffice(2);

		// TODO: 5/26/20 как думашь стоит уже убрать копипасту, или может создать бизнес центр?
		List<Secretary> secretaries = personProvider.getSomeSecretaries(1000);
		List<Security> securities = personProvider.getSomeSecurities(1000);
		List<Jurist> jurists = personProvider.getSomeJurists(1000);
		List<Accountant> accountants = personProvider.getSomeAccountants(1000);

	    // TODO: 5/31/20 6 аргуменотв многовато бывают, офисы где должностей побольше, что будешь делать?
	    //  и потом почему 3 раза бухгалтера? а понял, жесть? Как насчет завсети поле в офисе requiredQtyOfAccountants и инициализировать его при создании объекта офис
	    //  и потом все было нормально, создание офиса нужно было просто вывести в отдельный метод и все(офиса а не офисов!)


		sovaOffice.get(0).work(secretaries, securities, jurists, accountants, accountants, accountants);
	    // TODO: 5/31/20 да и 5 тоже

		sovaOffice.get(1).work(secretaries, securities, jurists, accountants, accountants);
		/*
			Понимаю прекрасно, что если офисов будет 1000, то будет весьма сложно. И если было бы во всех
			офисах одинаковое количество сотрудников по каждой специальности, то можно это все делать в цикле.
			Однако, с учетом того, что в одном офисе 3 бухгалтера, а в другом 2, то не получается сделать цикл.

			Секретари фильтруют всех кандидатов по возрасту. С методом из области черной магии не разобрался,
			хотя похоже на рефлексию, про нее почитал. Метод, я так понял, нужен для того, чтобы он был один
			и избавиться от различных методов getSomeДолжность. Что касается характеров директоров, то тоже не
			совсем ясно, что имеется ввиду.
		 */

		for(int i = 0; i < sovaOffice.size(); i++){
			sovaOffice.get(i).listWorkers();
		}



		// TODO: 5/26/20 какие-то они у тебя бездушные, давай один директор будет добрый а другой капризный, только не на совах а на деле.


    }
}
